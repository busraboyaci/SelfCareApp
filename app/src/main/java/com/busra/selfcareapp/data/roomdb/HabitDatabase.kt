package com.busra.selfcareapp.data.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.busra.selfcareapp.data.Converters

//@Database(entities = [HabitDbModel::class], version = 4)
@Database(entities = [HabitDbModel::class, HabitCompletion::class], version = 6, exportSchema = true)
@TypeConverters(Converters::class)
abstract class HabitDatabase: RoomDatabase() {
    abstract val dao: HabitDao
}