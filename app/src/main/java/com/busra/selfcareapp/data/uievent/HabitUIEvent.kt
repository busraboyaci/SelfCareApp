package com.busra.selfcareapp.data.uievent

open class HabitUIEvent {
    data class HabitNameChanged(val habitName: String): HabitUIEvent()
    object AddHabitButton : HabitUIEvent()


}