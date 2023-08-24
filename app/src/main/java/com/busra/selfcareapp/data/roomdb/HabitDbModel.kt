package com.busra.selfcareapp.data.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HabitDbModel(
    val habitName: String,
    val habitDescription: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
    
)