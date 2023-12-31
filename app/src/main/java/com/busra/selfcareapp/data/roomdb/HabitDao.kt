package com.busra.selfcareapp.data.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitDao {
    @Upsert
    fun upsertHabit(habit: HabitDbModel)

    @Delete
    suspend fun deleteHabit(habit: HabitDbModel)

    @Query("SELECT * FROM habit_table ORDER BY habitName ASC")
    fun getContactOrderedByHabitName(): Flow<List<HabitDbModel>>

    @Query("SELECT COUNT(*) FROM habit_table")
    suspend fun getHabitCount(): Int
    @Query("SELECT * FROM habit_table WHERE id = :habitId")
    suspend fun getHabitById(habitId: Int): HabitDbModel?

}