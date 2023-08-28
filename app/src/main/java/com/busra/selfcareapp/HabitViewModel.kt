package com.busra.selfcareapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.busra.selfcareapp.data.roomdb.HabitDao
import com.busra.selfcareapp.data.roomdb.HabitDbModel
import com.busra.selfcareapp.data.roomdb.SortType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HabitViewModel(
    private val dao: HabitDao
): ViewModel() {
    private val _shortType = MutableStateFlow(SortType.HABIT_NAME)
    private val _habits = _shortType
        .flatMapLatest { shortType ->
            when (shortType) {
                SortType.HABIT_NAME -> dao.getContactOrderedByHabitName()
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
    private val _state = MutableStateFlow(HabitState())

    val state = combine(_state, _shortType, _habits) { state, sortType, habits->
        state.copy(
            sortType = sortType,
            habits = habits
            )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), HabitState())

    //    some user interaction like = user press a button ext.
    fun onEvent(event: HabitEvent){
        when(event){
            HabitEvent.SaveHabit -> {
                val habitName = state.value.habitName
                val habitDescription = state.value.habitDescription
                val iconResName = state.value.iconResName

                if (habitName.isBlank() || habitDescription.isBlank()){
                    return
                }
                val habit = HabitDbModel(
                    habitName = habitName,
                    habitDescription = habitDescription,
                    iconResName = iconResName
                )
                viewModelScope.launch {
                    dao.upsertHabit(habit)
                }
                _state.update {
                    it.copy(
                        isAddingState = false,
                        habitName = "",
                        habitDescription = ""
                    )
                }
            }
            is HabitEvent.SetHabitDescription -> {
                viewModelScope.launch {
                    _state.update {
                        it.copy(
                            habitDescription = event.habitDescription
                        )
                    }
                }
            }
            is HabitEvent.SetHabitName -> {
                viewModelScope.launch {
                    _state.update {
                        it.copy(
                            habitName = event.habitName
                        )
                    }
                }
            }
//            is HabitEvent.SortHabits -> TODO()
            is HabitEvent.DeleteHabit -> {
                viewModelScope.launch {
                    dao.deleteHabit(event.habit)
                }
            }
            is HabitEvent.SelectHabit -> {
                viewModelScope.launch {
                    _state.update {
                        it.copy(
                            selectedItem = event.selectHabit
                        )
                    }
                }
            }
        }
    }

    // Variable to track the insertion state
    private var defaultItemsInserted = false

    // Function to check if default items are inserted
    fun areDefaultItemsInserted(): Boolean {
        return defaultItemsInserted
    }

    // Function to set the insertion state
    fun setDefaultItemsInserted(inserted: Boolean) {
        defaultItemsInserted = inserted
    }


}