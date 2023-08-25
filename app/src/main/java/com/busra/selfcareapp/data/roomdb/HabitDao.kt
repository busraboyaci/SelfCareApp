package com.busra.selfcareapp.data.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitDao {
    @Upsert
    suspend fun upsertHabit(habit: HabitDbModel)

    @Delete
    suspend fun deleteHabit(habit: HabitDbModel)

    @Query("SELECT * FROM habitdbmodel ORDER BY habitName ASC")
    fun getContactOrderedByHabitName(): Flow<List<HabitDbModel>>

    @Query("SELECT COUNT(*) FROM habitdbmodel")
    suspend fun getHabitCount(): Int

}