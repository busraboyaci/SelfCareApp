package com.busra.selfcareapp.data.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.busra.selfcareapp.data.repository.HabitRepository
import com.busra.selfcareapp.data.roomdb.HabitDbModel
import kotlinx.coroutines.launch

class EditHabitScreenViewModel(private val habitRepository: HabitRepository) : ViewModel()  {
    fun updateHabit(habit: HabitDbModel) {
        viewModelScope.launch {
            habitRepository.updateHabit(habit)
        }
    }
}