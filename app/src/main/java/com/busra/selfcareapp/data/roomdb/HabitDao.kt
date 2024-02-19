package com.busra.selfcareapp.data.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

@Dao
interface HabitDao {
    @Upsert
    fun upsertHabit(habit: HabitDbModel)

    @Delete
    suspend fun deleteHabit(habit: HabitDbModel)

    @Insert
    suspend fun insertHabit(habit: HabitDbModel)

    @Insert
    suspend fun insertCompletion(completion: HabitCompletion)


    @Query("SELECT * FROM habit_table ORDER BY habitName ASC")
    fun getContactOrderedByHabitName(): Flow<List<HabitDbModel>>

    @Query("SELECT COUNT(*) FROM habit_table")
    suspend fun getHabitCount(): Int
    @Query("SELECT * FROM habit_table WHERE id = :habitId")
    suspend fun getHabitById(habitId: Int): HabitDbModel?

    @Query("SELECT * FROM habit_table")
    suspend fun getAllHabits(): List<HabitDbModel>

    @Transaction
    @Query("SELECT * FROM habit_table")
    suspend fun getHabitsWithCompletions(): List<HabitWithCompletions>

    // Query to get completion date for a habit by habitId
    @Query("SELECT completion_date FROM habit_completion_table WHERE habit_id = :habitId")
    fun getCompletionDateForHabit(habitId: Int): LocalDate?

}