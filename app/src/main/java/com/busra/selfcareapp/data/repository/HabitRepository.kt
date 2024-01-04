package com.busra.selfcareapp.data.repository

import com.busra.selfcareapp.data.roomdb.HabitDao
import com.busra.selfcareapp.data.roomdb.HabitDbModel
import kotlinx.coroutines.flow.Flow

class HabitRepository(private val habitDao: HabitDao) {
    fun updateHabit(habit: HabitDbModel) {
        habitDao.upsertHabit(habit)
    }

    fun upsertHabit(habit: HabitDbModel){
        habitDao.upsertHabit(habit)
    }

    suspend fun deleteHabit(habit: HabitDbModel){
        habitDao.deleteHabit(habit)
    }

    fun getCurrentHabitList(habitList: List<HabitDbModel>) {

    }

    fun getContactOrderedByHabitName(): Flow<List<HabitDbModel>> {
        return habitDao.getContactOrderedByHabitName()
    }


}