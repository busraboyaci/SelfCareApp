package com.busra.selfcareapp

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.room.Room
import com.busra.selfcareapp.app.SelfCareApp
import com.busra.selfcareapp.data.repository.HabitRepository
import com.busra.selfcareapp.data.roomdb.HabitDao
import com.busra.selfcareapp.data.roomdb.HabitDatabase
import com.busra.selfcareapp.data.viewModel.HomeViewModel
import com.busra.selfcareapp.navigate.Screen
import com.busra.selfcareapp.navigate.SelfCareAppRouter
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// Define the HabitDatabase instance as a property with lateinit
private lateinit var db: HabitDatabase

private val habitRepository by lazy {
    HabitRepository(db.dao)
}

class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.statusBarColor = resources.getColor(R.color.primary)

        // Initialize the HabitDatabase within the onCreate method
        db = Room.databaseBuilder(
            application,
            HabitDatabase::class.java,
            "HabitDatabase.db"
        ).build()
        // Initialize other properties after initializing the HabitDatabase
        val userSettingsManager by lazy {
            (application as SelfCareApp).userSettingsManager
        }

        val viewModel by viewModels<HabitViewModel>(
            factoryProducer = {
                object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(
                        modelClass: Class<T>,
                        extras: CreationExtras
                    ): T {
                        return HabitViewModel(habitRepository) as T
                    }
                }
            }
        )

        lifecycleScope.launch {
            val defaultItemsInserted = viewModel.areDefaultItemsInserted()

            if (!defaultItemsInserted) {
                val habitCount = withContext(Dispatchers.IO) {
                    db.dao.getHabitCount()
                }

                if (habitCount == 0) {
                    // Insert default items
                    withContext(Dispatchers.IO) {
                        insertDefaultItems(habitRepository)
                    }
                    viewModel.setDefaultItemsInserted(true)
                } else {
                    viewModel.setDefaultItemsInserted(true)
                }
            }
        }


        setContent {

            val checkboxValue by userSettingsManager.getCheckboxValueFlow.collectAsState(initial = false)
            if (checkboxValue) {
                if (FirebaseAuth.getInstance().currentUser != null) {
                    // User is logged in, and "Remember Me" is checked, navigate to HomeScreen
                    SelfCareAppRouter.currentScreen.value = Screen.HomeScreen
                } else {
                    // User is not logged in, so they need to log in again
                    // You can navigate to the login screen here or handle it as needed.
                }
            } else {
                // "Remember Me" is not checked, user needs to log in
                // You can navigate to the login screen here or handle it as needed.

            }

            //            TODO: login checkbox test et - Test yaz !.
            SelfCareApp(viewModel)
//            MainScreen()


        }
    }
}
