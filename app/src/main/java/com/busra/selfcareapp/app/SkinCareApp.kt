package com.busra.selfcareapp.app

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.busra.selfcareapp.bottombar.BottomNavGraph
import com.busra.selfcareapp.data.LoginViewModel
import com.busra.selfcareapp.navigate.ObserveScreenChanges
import com.busra.selfcareapp.navigate.Screen
import com.busra.selfcareapp.navigate.SelfCareAppRouter
import com.busra.selfcareapp.screens.AddHabitScreen
import com.busra.selfcareapp.screens.BottomBar
import com.busra.selfcareapp.screens.HomeScreen
import com.busra.selfcareapp.screens.LoginScreen
import com.busra.selfcareapp.screens.MainScreen
import com.busra.selfcareapp.screens.ProfileScreen
import com.busra.selfcareapp.screens.SettingsScreen
import com.busra.selfcareapp.screens.SignUpScreen
import com.busra.selfcareapp.screens.TermsAndConditionScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SelfCareApp() {
//    surface is a container
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomBar(navController = navController) }

    ) {
        ObserveScreenChanges()
        BottomNavGraph(navController)
        Crossfade(targetState = SelfCareAppRouter.currentScreen, label = "") { currentState ->
            println("currentState.value SkinCareApp: " + currentState.value)
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
                    HomeScreen()

                }

                is Screen.AddHabitScreen -> {
                    Log.d("AddHabitScreen", "AddHabitScreen()")
                    AddHabitScreen()
                }

                is Screen.SettingsScreen -> {
                    Log.d("SettingsScreen", "SettingsScreen()")
                    SettingsScreen()
                }

                is Screen.ProfileScreen -> {
                    Log.d("ProfileScreen", "ProfileScreen()")
                    ProfileScreen()
                }
            }
        }

    }
}