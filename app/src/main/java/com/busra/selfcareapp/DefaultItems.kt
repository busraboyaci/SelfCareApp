package com.busra.selfcareapp

import com.busra.selfcareapp.data.roomdb.HabitDatabase
import com.busra.selfcareapp.data.roomdb.HabitDbModel

val defaultItems = listOf(
    HabitDbModel(habitName = "Skin care", iconResName = "skincare", habitDescription = "Description 1", backgroundColor = R.color.cream_yellow),
    HabitDbModel(habitName = "Prepare healthy meal", iconResName = "salad", habitDescription = "Description 2", backgroundColor = R.color.teal_200),
    HabitDbModel(habitName = "8 hours sleep", iconResName = "sleeping", habitDescription = "Description 3", backgroundColor = R.color.light_pink),
    HabitDbModel(habitName = "Something", iconResName = "star", habitDescription = "Description 4", backgroundColor = R.color.purple_500),
    HabitDbModel(habitName = "Investing", iconResName = "revenue", habitDescription = "Description 5", backgroundColor = R.color.soft_yellow),
    HabitDbModel(habitName = "Pilates", iconResName = "pilates", habitDescription = "Description 6", backgroundColor = R.color.soft_yellow),
    HabitDbModel(habitName = "Ice cream", iconResName = "laughing", habitDescription = "Description 5", backgroundColor = R.color.soft_pink),
    HabitDbModel(habitName = "bicycle", iconResName = "hamburger", habitDescription = "Description 5", backgroundColor = R.color.teal_700),
    HabitDbModel(habitName = "cleaning", iconResName = "cleaning", habitDescription = "Description 5", backgroundColor = R.color.cream_yellow),
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