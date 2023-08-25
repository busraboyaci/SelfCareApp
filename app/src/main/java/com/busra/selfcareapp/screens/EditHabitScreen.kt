package com.busra.selfcareapp.screens

import androidx.compose.runtime.Composable
import com.busra.selfcareapp.navigate.Screen
import com.busra.selfcareapp.navigate.SelfCareAppRouter
import com.busra.selfcareapp.navigate.SystemBackButtonHandler

@Composable
fun EditHabitScreen() {

    SystemBackButtonHandler {
        SelfCareAppRouter.navigateTo(Screen.AddHabitScreen)
    }
    
}