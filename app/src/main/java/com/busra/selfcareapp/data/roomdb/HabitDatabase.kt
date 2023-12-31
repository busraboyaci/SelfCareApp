package com.busra.selfcareapp.data.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [HabitDbModel::class], version = 4)
abstract class HabitDatabase: RoomDatabase() {
    abstract val dao: HabitDao
}