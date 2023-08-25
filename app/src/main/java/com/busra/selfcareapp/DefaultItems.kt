package com.busra.selfcareapp

import com.busra.selfcareapp.data.roomdb.HabitDatabase
import com.busra.selfcareapp.data.roomdb.HabitDbModel

val defaultItems = listOf(
    HabitDbModel(habitName = "Skin care", iconResName = "skincare", habitDescription = "Description 1"),
    HabitDbModel(habitName = "Prepare healthy meal", iconResName = "salad", habitDescription = "Description 2"),
    HabitDbModel(habitName = "8 hours sleep", iconResName = "sleeping", habitDescription = "Description 3"),
    HabitDbModel(habitName = "Something", iconResName = "star", habitDescription = "Description 4"),
    HabitDbModel(habitName = "Investing", iconResName = "revenue", habitDescription = "Description 5"),
    HabitDbModel(habitName = "Pilates", iconResName = "pilates", habitDescription = "Description 6"),
    HabitDbModel(habitName = "Ice cream", iconResName = "laughing", habitDescription = "Description 5"),
    HabitDbModel(habitName = "bicycle", iconResName = "hamburger", habitDescription = "Description 5"),
    HabitDbModel(habitName = "cleaning", iconResName = "cleaning", habitDescription = "Description 5"),
//    HabitDbModel(habitName = "Item 5", iconResName = "yoga", habitDescription = "Description 5"),
//    HabitDbModel(habitName = "Item 5", iconResName = "yoga", habitDescription = "Description 5"),
//    HabitDbModel(habitName = "Item 5", iconResName = "yoga", habitDescription = "Description 5"),
//    HabitDbModel(habitName = "Item 5", iconResName = "yoga", habitDescription = "Description 5"),
//    HabitDbModel(habitName = "Item 5", iconResName = "yoga", habitDescription = "Description 5"),
//    HabitDbModel(habitName = "Item 5", iconResName = "yoga", habitDescription = "Description 5"),
//    HabitDbModel(habitName = "Item 5", iconResName = "yoga", habitDescription = "Description 5")
)
suspend fun insertDefaultItems(database: HabitDatabase) {
    val dao = database.dao
    defaultItems.forEach { habit ->
        dao.upsertHabit(habit)
    }
}