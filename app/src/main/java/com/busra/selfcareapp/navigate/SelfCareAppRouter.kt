package com.busra.selfcareapp.navigate

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.datastore.dataStore
import com.busra.selfcareapp.SelfCareApp

sealed class Screen {
    object SignUpScreen : Screen()
    object TermsAndConditionScreen : Screen()
    object LoginScreen: Screen()
    object HomeScreen: Screen()
    object AddHabitScreen: Screen()
    object SettingsScreen: Screen()
    object ProfileScreen: Screen()
}

object SelfCareAppRouter{

    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.LoginScreen)
    fun navigateTo(destination: Screen){
        currentScreen.value = destination
    }
}

// Ekran değişikliklerini gözlemlemek için bir Composable bileşen örneği
@Composable
fun ObserveScreenChanges() {
    val currentScreen = SelfCareAppRouter.currentScreen.value

    // currentScreen.value'yi görsel bir değişiklikle güncellemek için UI bileşenlerini kullanın
    Text(text = "Current Screen: ${currentScreen.javaClass.simpleName}")
}