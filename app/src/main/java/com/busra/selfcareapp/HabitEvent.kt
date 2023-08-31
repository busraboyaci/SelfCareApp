package com.busra.selfcareapp

import com.busra.selfcareapp.data.roomdb.HabitDbModel


sealed interface HabitEvent {
    object SaveHabit: HabitEvent
    data class SetHabitName(val habitName: String): HabitEvent
    data class SetHabitDescription(val habitDescription: String): HabitEvent
    data class DeleteHabit(val habit: HabitDbModel): HabitEvent
    data class SelectHabit(val selectHabit: HabitDbModel): HabitEvent
    data class UpdateHabit(val habit: HabitDbModel): HabitEvent

//    data class SortHabits(val sortType: SortType): HabitEvent

}