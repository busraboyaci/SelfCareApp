package com.busra.selfcareapp

import com.busra.selfcareapp.data.roomdb.HabitDatabase
import com.busra.selfcareapp.data.roomdb.HabitDbModel

val defaultItems = listOf(
    HabitDbModel(habitName = "Item 1", habitDescription = "Description 1"),
    HabitDbModel(habitName = "Item 2", habitDescription = "Description 2"),
    HabitDbModel(habitName = "Item 3", habitDescription = "Description 3"),
    HabitDbModel(habitName = "Item 4", habitDescription = "Description 4"),
    HabitDbModel(habitName = "Item 5", habitDescription = "Description 5")
)
suspend fun insertDefaultItems(database: HabitDatabase) {
    val dao = database.dao
    defaultItems.forEach { habit ->
        dao.upsertHabit(habit)
    }
}