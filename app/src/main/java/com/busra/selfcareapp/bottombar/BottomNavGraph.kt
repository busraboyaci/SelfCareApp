package com.busra.selfcareapp.bottombar

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.busra.selfcareapp.navigate.ObserveScreenChanges
import com.busra.selfcareapp.navigate.Screen
import com.busra.selfcareapp.navigate.SelfCareAppRouter


@Composable
fun BottomNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route){
            SelfCareAppRouter.navigateTo(Screen.HomeScreen)
        }
        composable(route = BottomBarScreen.Profile.route){
//            ObserveScreenChanges()
            SelfCareAppRouter.navigateTo(Screen.ProfileScreen)
        }
        composable(route = BottomBarScreen.Settings.route){
            SelfCareAppRouter.navigateTo(Screen.SettingsScreen)
        }
    }
}