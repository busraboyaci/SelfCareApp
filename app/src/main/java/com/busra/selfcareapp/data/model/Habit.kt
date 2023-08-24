package com.busra.selfcareapp.data.model

import android.graphics.drawable.Icon
import androidx.room.Entity

data class Habit(
    val id: Int,
    val habitIcon: Int,
    val habitDescription: String,
    val addHabitIcon: Int
)
