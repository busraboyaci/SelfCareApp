package com.busra.selfcareapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Edit Habit",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

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