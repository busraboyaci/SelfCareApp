package com.busra.selfcareapp.data.roomdb

import androidx.room.Embedded
import androidx.room.Relation

data class HabitWithCompletions(
    @Embedded val habit: HabitDbModel,
    @Relation(
        parentColumn = "id",
        entityColumn = "habit_id"
    )
    val completions: List<HabitCompletion>
)