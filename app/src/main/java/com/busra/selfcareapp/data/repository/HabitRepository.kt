package com.busra.selfcareapp.data.repository

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import com.busra.selfcareapp.data.roomdb.HabitCompletion
import com.busra.selfcareapp.data.roomdb.HabitDao
import com.busra.selfcareapp.data.roomdb.HabitDbModel
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class HabitRepository(val habitDao: HabitDao) {
    fun updateHabit(habit: HabitDbModel) {
        habitDao.upsertHabit(habit)
    }

    fun upsertHabit(habit: HabitDbModel) {
        habitDao.upsertHabit(habit)
    }

    suspend fun deleteHabit(habit: HabitDbModel) {
        habitDao.deleteHabit(habit)
    }

    suspend fun getAllHabit() {
        habitDao.getAllHabits()
    }

    suspend fun insertHabit(habit: HabitDbModel) {
        habitDao.insertHabit(habit)
    }

    fun getContactOrderedByHabitName(): Flow<List<HabitDbModel>> {
        return habitDao.getContactOrderedByHabitName()
    }

    suspend fun getHabitById(habitId: Int): HabitDbModel? {
        return habitDao.getHabitById(habitId)
    }

    // Function to get all habits where systemDefined is false
//    suspend fun getAllNonSystemDefinedHabits(): List<HabitDbModel> {
//        return habitDao.getAllHabits().filter { !it.systemDefined }
//    }
    suspend fun getAllNonSystemDefinedHabits(targetDate: LiveData<LocalDate>): List<HabitDbModel> {
        val currentDate = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalDate.now()
        } else {
            TODO("VERSION.SDK_INT < O")
        }
        return habitDao.getHabitsWithCompletions().map { habitWithCompletions ->
            Log.d("habitname", habitWithCompletions.habit.habitName)
            Log.d("currentDate", currentDate.toString())
            Log.d("targetDate", targetDate.value.toString())
            // Check if the habit is not systemDefined and has no completion for the current date
            if (!habitWithCompletions.habit.systemDefined &&
                habitWithCompletions.completions.none { it.completionDate == currentDate }
            ) {
                habitWithCompletions.habit // Include the habit in the result list
            } else if (!habitWithCompletions.habit.systemDefined &&
                habitWithCompletions.completions.none { it.completionDate == targetDate.value }
            ) {
                print("habitname: ${habitWithCompletions.habit.habitName}, targetDate: $currentDate")
                habitWithCompletions.habit // Include the habit in the result list
            } else {
                null // Exclude the habit from the list
            }
        }.filterNotNull() // Remove null elements from the list
    }

    // Function to mark a habit as completed for the current date
    suspend fun markHabitCompleted(habitId: Int) {
        val completion = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            HabitCompletion(habitId = habitId, completionDate = LocalDate.now())
        } else {
            TODO("VERSION.SDK_INT < O")
        }
        habitDao.insertCompletion(completion)
    }

    suspend fun changeCalenderDate(habitId: Int){
        habitDao.getCompletionDateForHabit(habitId)
    }


}