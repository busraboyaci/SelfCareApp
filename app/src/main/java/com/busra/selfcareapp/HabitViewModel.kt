package com.busra.selfcareapp

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.busra.selfcareapp.data.repository.HabitRepository
import com.busra.selfcareapp.data.roomdb.HabitCompletion
import com.busra.selfcareapp.data.uievent.HabitUIEvent
import com.busra.selfcareapp.data.uistate.HabitUIState
import com.busra.selfcareapp.data.roomdb.HabitDao
import com.busra.selfcareapp.data.roomdb.HabitDbModel
import com.busra.selfcareapp.data.roomdb.SortType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HabitViewModel(
//    private val dao: HabitDao,
    private val habitRepository: HabitRepository) : ViewModel()
 { private val TAG = HabitViewModel::class.simpleName
    private var habitUIState = mutableStateOf(HabitUIState())
     private val _shortType = MutableStateFlow(SortType.HABIT_NAME)
     private val _savedHabitList = MutableLiveData<List<HabitDbModel>>()
     val savedHabitList: MutableLiveData<List<HabitDbModel>> = _savedHabitList
     private val _habits = _shortType

         .flatMapLatest { shortType ->
            when (shortType) {
                SortType.HABIT_NAME -> habitRepository.getContactOrderedByHabitName()
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
    private val _state = MutableStateFlow(HabitState())
     init {
         viewModelScope.launch {
             loadSavedHabits()
         }
     }
    val state = combine(_state, _shortType, _habits) { state, sortType, habits ->
        state.copy(
            sortType = sortType,
            habits = habits
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), HabitState())

    //    some user interaction like = user press a button ext.
    fun onEvent(event: HabitEvent) {
        when (event) {
            HabitEvent.SaveHabit -> {
                val habitName = state.value.habitName
                val habitDescription = state.value.habitDescription
                val iconResName = state.value.iconResName
                val backgroundColor = state.value.backgroundColour

                if (habitName.isBlank() || habitDescription.isBlank()) {
                    return
                }
                val habit = HabitDbModel(
                    habitName = habitName,
                    habitDescription = habitDescription,
                    iconResName = iconResName,
                    backgroundColor = backgroundColor
                )
                viewModelScope.launch {
                    habitRepository.upsertHabit(habit)
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
                    habitRepository.deleteHabit(event.habit)
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

            is HabitEvent.UpdateHabit -> {
                viewModelScope.launch {
                    habitRepository.upsertHabit(event.habit)
                }
            }
            is HabitEvent.MarkHabitCompleted ->{
                viewModelScope.launch {
                    habitRepository.markHabitCompleted(event.markHabitCompleted)
                }
            }
        }
    }

     private suspend fun loadSavedHabits() {
         _savedHabitList.value = habitRepository.getAllNonSystemDefinedHabits()
     }

    fun habitUIEvent(event: HabitUIEvent) {
        when (event) {
            is HabitUIEvent.HabitNameChanged -> {
                habitUIState.value = habitUIState.value.copy(
                    habitName = event.habitName
                )
                printState()
            }
            is HabitUIEvent.SetHabitBackground -> {
                habitUIState.value = habitUIState.value.copy(
                    habitBackground = event.habitBackground
                )
                printState()
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

    private fun printState() {
        Log.d(TAG, "Inside_printState")
        Log.d(TAG, habitUIState.value.toString())
    }

    fun updateHabit(habit: HabitDbModel) {
        viewModelScope.launch {
            habitRepository.upsertHabit(habit)
        }
    }

    fun setSystemDefinedToFalse(habit: HabitDbModel) {

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val updatedHabit = habit.copy(systemDefined = !habit.systemDefined)
                habitRepository.upsertHabit(updatedHabit)
            }
        }
    }

     suspend fun getCurrentHabitList() {
         viewModelScope.launch {
             val currentHabit = habitRepository.getAllNonSystemDefinedHabits()
             print("currentHabit - viewmodelScope: "+ habitRepository.getAllNonSystemDefinedHabits())
             saveHabitList(currentHabit)
         }
     }

     private fun saveHabitList(habitList: List<HabitDbModel> ) {
         _savedHabitList.value = habitList // You can update the list according to your logic
     }





}