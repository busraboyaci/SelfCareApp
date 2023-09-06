package com.busra.selfcareapp.data.uievent

import com.busra.selfcareapp.HabitEvent

open class HabitUIEvent {
    data class HabitNameChanged(val habitName: String): HabitUIEvent()
    data class SetHabitBackground(val habitBackground: Int): HabitUIEvent()

    object AddHabitButton : HabitUIEvent()



}