package com.busra.selfcareapp.data.repository

import com.busra.selfcareapp.data.roomdb.HabitDao
import com.busra.selfcareapp.data.roomdb.HabitDbModel
import kotlinx.coroutines.flow.Flow

class HabitRepository(val habitDao: HabitDao) {
    fun updateHabit(habit: HabitDbModel) {
        habitDao.upsertHabit(habit)
    }

    fun upsertHabit(habit: HabitDbModel){
        habitDao.upsertHabit(habit)
    }

    suspend fun deleteHabit(habit: HabitDbModel){
        habitDao.deleteHabit(habit)
    }

    suspend fun getAllHabit(){
        habitDao.getAllHabits()
    }

    suspend fun insertHabit(habit:HabitDbModel){
        habitDao.insertHabit(habit)
    }

    fun getContactOrderedByHabitName(): Flow<List<HabitDbModel>> {
        return habitDao.getContactOrderedByHabitName()
    }

    suspend fun getHabitById(habitId: Int): HabitDbModel?{
        return habitDao.getHabitById(habitId)
    }

    // Function to get all habits where systemDefined is false
    suspend fun getAllNonSystemDefinedHabits(): List<HabitDbModel> {
        return habitDao.getAllHabits().filter { !it.systemDefined }
    }


}