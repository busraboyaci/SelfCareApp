package com.busra.selfcareapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.busra.selfcareapp.HabitState
import com.busra.selfcareapp.R
import com.busra.selfcareapp.components.EditHabitScreenTopRow
import com.busra.selfcareapp.data.roomdb.HabitDbModel
import com.busra.selfcareapp.navigate.Screen
import com.busra.selfcareapp.navigate.SelfCareAppRouter
import com.busra.selfcareapp.navigate.SystemBackButtonHandler

@Composable
fun EditHabitScreen(selectedHabit: HabitDbModel) {


    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.cream))
    ) {
//        column  ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(colorResource(id = R.color.cream))
                .padding(top = 10.dp)
        ) {
            EditHabitScreenTopRow(onButtonClicked = {
                SelfCareAppRouter.navigateTo(Screen.AddHabitScreen)
            })

            // Seçili habit'a ait bilgileri Text olarak göster
            Text(text = "Habit Name: ${selectedHabit.habitName}")
            Text(text = "Habit Description: ${selectedHabit.habitDescription}")
            Text(text = "Icon Resource: ${selectedHabit.iconResName}")

            // Gerekli diğer bileşenleri ekleyebilirsiniz
        }
    }

    SystemBackButtonHandler {
        SelfCareAppRouter.navigateTo(Screen.AddHabitScreen)
    }
}