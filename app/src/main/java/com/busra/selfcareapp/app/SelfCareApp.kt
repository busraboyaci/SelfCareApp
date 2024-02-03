package com.busra.selfcareapp.app

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.busra.selfcareapp.HabitEvent
import com.busra.selfcareapp.HabitViewModel
import com.busra.selfcareapp.bottombar.BottomNavGraph
import com.busra.selfcareapp.data.viewModel.HomeViewModel
import com.busra.selfcareapp.insertDefaultItems
import com.busra.selfcareapp.navigate.ObserveScreenChanges
import com.busra.selfcareapp.navigate.Screen
import com.busra.selfcareapp.navigate.SelfCareAppRouter
import com.busra.selfcareapp.navigate.SelfCareAppRouter.currentScreen
import com.busra.selfcareapp.screens.AddHabitScreen
import com.busra.selfcareapp.screens.BottomBar
import com.busra.selfcareapp.screens.EditHabitScreen
import com.busra.selfcareapp.screens.HomeScreen
import com.busra.selfcareapp.screens.LoginScreen
import com.busra.selfcareapp.screens.ProfileScreen
import com.busra.selfcareapp.screens.SettingsScreen
import com.busra.selfcareapp.screens.SignUpScreen
import com.busra.selfcareapp.screens.TermsAndConditionScreen
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SelfCareApp(
    viewModel: HabitViewModel,
) {
//    surface is a container
    val navController = rememberNavController()
    val currentScreen = SelfCareAppRouter.currentScreen.value // Access the current screen value
    val state by viewModel.state.collectAsState() // ViewModel'den state'i al
    val selectedItem = state.selectedItem // Seçili öğe

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (currentScreen is Screen.HomeScreen ||
                currentScreen is Screen.ProfileScreen ||
                currentScreen is Screen.SettingsScreen
            ) {
                BottomBar(navController = navController)
            }
        }
    ) {
        ObserveScreenChanges()
        Crossfade(targetState = SelfCareAppRouter.currentScreen, label = "") { currentState ->
            when (currentState.value) {

                is Screen.SignUpScreen -> {
                    Log.d("SkincareApp", "SignUpScreen()")
                    SignUpScreen()
                }

                is Screen.TermsAndConditionScreen -> {
                    Log.d("TermsAndConditionScreen", "TermsAndConditionScreen()")
                    TermsAndConditionScreen()
                }

                is Screen.LoginScreen -> {
                    LoginScreen()
                }

                is Screen.HomeScreen -> {
                    Log.d("HomeScreen", "HomeScreen()")
                    HomeScreenWithBottomNav(navController, onEvent = viewModel::onEvent)
                }

                is Screen.AddHabitScreen -> {
                    Log.d("AddHabitScreen", "AddHabitScreen()")
                    Log.d("state.selectedItem: ", state.selectedItem.toString())
                    AddHabitScreen(viewModel, onEvent = viewModel::onEvent)
                }

                is Screen.SettingsScreen -> {
                    Log.d("SettingsScreen", "SettingsScreen()")
                    SettingsScreenWithBottomNav(navController)
                }

                is Screen.ProfileScreen -> {
                    Log.d("ProfileScreen", "ProfileScreen()")
                    ProfileScreenWithBottomNav(navController)
                }

//                is Screen.EditHabitScreen -> {
//                    EditHabitScreen()
//                }
                is Screen.EditHabitScreen -> {
                    Log.d("EditHabitScreen", "EditHabitScreen()")
                    Log.d("selectedItem", state.selectedItem.toString())

                    selectedItem?.let {
                        EditHabitScreen(selectedItem)
                    }
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreenWithBottomNav(navController: NavHostController,
                            onEvent: (HabitEvent) -> Unit,
) {
    HomeScreen(onEvent = onEvent)
    BottomNavGraph(navController)
}

@Composable
fun SettingsScreenWithBottomNav(navController: NavHostController) {
    SettingsScreen()
    BottomNavGraph(navController)
}

@Composable
fun ProfileScreenWithBottomNav(navController: NavHostController) {
    ProfileScreen()
    BottomNavGraph(navController)
}