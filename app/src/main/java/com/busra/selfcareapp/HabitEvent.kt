package com.busra.selfcareapp

import com.busra.selfcareapp.data.roomdb.HabitDbModel
import com.busra.selfcareapp.data.roomdb.SortType


sealed interface HabitEvent {
    object SaveHabit: HabitEvent
    data class SetHabitName(val habitName: String): HabitEvent
    data class SetHabitDescription(val habitDescription: String): HabitEvent
    data class DeleteHabit(val habit: HabitDbModel): HabitEvent
    data class SelectHabit(val habit: HabitDbModel): HabitEvent
//    data class SortHabits(val sortType: SortType): HabitEvent

}