package com.busra.selfcareapp.data.repository

import com.busra.selfcareapp.data.roomdb.HabitDao
import com.busra.selfcareapp.data.roomdb.HabitDbModel

class HabitRepository(private val habitDao: HabitDao) {
    fun updateHabit(habit: HabitDbModel) {
        habitDao.upsertHabit(habit)
    }


}