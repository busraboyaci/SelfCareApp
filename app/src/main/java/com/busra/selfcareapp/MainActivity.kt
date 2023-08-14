package com.busra.selfcareapp

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.busra.selfcareapp.app.SelfCareApp
import com.busra.selfcareapp.navigate.Screen
import com.busra.selfcareapp.screens.HomeScreen

class MainActivity : ComponentActivity() {
    private val userSettingsManager by lazy {
        (application as SelfCareApp).userSettingsManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.statusBarColor = resources.getColor(R.color.primary)

        setContent {
            val checkboxValue by userSettingsManager.getCheckboxValueFlow.collectAsState(initial = false)

            if (checkboxValue) {
                // Checkbox işaretli ise, direkt ana ekrana yönlendir
                HomeScreen()
            } else {
                // Checkbox işaretli değilse, giriş ekranına yönlendir
                SelfCareApp()
            }
        }
    }
}