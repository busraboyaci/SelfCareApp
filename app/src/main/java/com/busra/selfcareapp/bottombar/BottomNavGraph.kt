package com.busra.selfcareapp.bottombar

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.busra.selfcareapp.screens.AddHabitScreen
import com.busra.selfcareapp.screens.HomeScreen


@Composable
fun BottomNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route){
            HomeScreen()
        }
        composable(route = BottomBarScreen.Profile.route){
            AddHabitScreen()
        }
        composable(route = BottomBarScreen.Settings.route){
//            SettingsScreen()
        }
    }
}