package com.busra.selfcareapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.room.Room
import com.busra.selfcareapp.app.SelfCareApp
import com.busra.selfcareapp.data.roomdb.HabitDatabase
import com.busra.selfcareapp.navigate.Screen
import com.busra.selfcareapp.navigate.SelfCareAppRouter
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            HabitDatabase::class.java,
            "habits.db"
        ).build()
    }
    // Varsayılan verileri ekle

    private val userSettingsManager by lazy {
        (application as SelfCareApp).userSettingsManager
    }

    private val viewModel by viewModels<HabitViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                    return HabitViewModel(db.dao) as T
                }
            }
        }
    )

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.statusBarColor = resources.getColor(R.color.primary)
// Check if default items are already inserted
        val defaultItemsInserted = viewModel.areDefaultItemsInserted()

        if (!defaultItemsInserted) {
            // Insert default items
            lifecycleScope.launch {
                insertDefaultItems(db)
                viewModel.setDefaultItemsInserted(true)
            }
        }


        setContent {

            val checkboxValue by userSettingsManager.getCheckboxValueFlow.collectAsState(initial = false)
            if (checkboxValue) {
                SelfCareAppRouter.currentScreen.value = Screen.HomeScreen
            }
            val state by viewModel.state.collectAsState()


//            TODO: login checkbox test et - Test yaz !.
            SelfCareApp(state = state, onEvent = viewModel::onEvent)
//            MainScreen()
        }
    }
}
