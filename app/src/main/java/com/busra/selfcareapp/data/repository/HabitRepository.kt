package com.busra.selfcareapp.data.repository

import androidx.compose.material.Icon
import com.busra.selfcareapp.R
import com.busra.selfcareapp.data.model.Habit

class HabitRepository {

    fun getAllData(): List<Habit>{
        return listOf(
            Habit(
                id = 0,
                habitDescription = "Yoga",
                habitIcon = R.drawable.hamburger_menu,
                addHabitIcon = R.drawable.back
            )
        )
    }
}