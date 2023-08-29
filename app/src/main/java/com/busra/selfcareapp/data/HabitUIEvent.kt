package com.busra.selfcareapp.data

sealed class HabitUIEvent {
    data class HabitNameChanged(val habitName: String): HabitUIEvent()
    object AddHabitButton : HabitUIEvent()


}