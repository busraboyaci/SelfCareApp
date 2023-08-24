package com.busra.selfcareapp

import com.busra.selfcareapp.data.roomdb.HabitDbModel
import com.busra.selfcareapp.data.roomdb.SortType

data class HabitState(
    val habits: List<HabitDbModel> = emptyList(),
    val habitName: String = "",
    val habitDescription: String = "",
    val isAddingState: Boolean = false,
    val sortType: SortType = SortType.HABIT_NAME


)