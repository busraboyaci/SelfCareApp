package com.busra.selfcareapp.app

import android.util.Log
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.busra.selfcareapp.navigate.Screen
import com.busra.selfcareapp.navigate.SelfCareAppRouter
import com.busra.selfcareapp.screens.LoginScreen
import com.busra.selfcareapp.screens.SignUpScreen
import com.busra.selfcareapp.screens.TermsAndConditionScreen

@Composable
fun SelfCareApp() {
//    surface is a container
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Crossfade(targetState = SelfCareAppRouter.currentScreen) { currentState ->
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
            }

        }

    }
}