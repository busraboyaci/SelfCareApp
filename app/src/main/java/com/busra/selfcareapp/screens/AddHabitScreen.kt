package com.busra.selfcareapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.busra.selfcareapp.HabitEvent
import com.busra.selfcareapp.HabitState
import com.busra.selfcareapp.HabitViewModel
import com.busra.selfcareapp.R
import com.busra.selfcareapp.components.AddHabitScreenTopRow
import com.busra.selfcareapp.components.CustomHabitLazyColum
import com.busra.selfcareapp.components.TextHeader
import com.busra.selfcareapp.data.LoginViewModel
import com.busra.selfcareapp.data.repository.HabitRepository
import com.busra.selfcareapp.data.roomdb.SortType
import com.busra.selfcareapp.navigate.ObserveScreenChanges
import com.busra.selfcareapp.navigate.Screen
import com.busra.selfcareapp.navigate.SelfCareAppRouter

@Composable
fun AddHabitScreen(
    state: HabitState,
    onEvent: (HabitEvent) -> Unit,
) {
//    val habitRepository = HabitRepository()
//    val getAllData = habitRepository.getAllData()
    
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.cream))
    ) { paddingValues ->
//        column  ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(colorResource(id = R.color.cream))
                .padding(top = 10.dp)
        ) {
//        Row -> satır geri dönüş tuşu ve arama tuşu
            AddHabitScreenTopRow(onButtonClicked = {
                SelfCareAppRouter.navigateTo(Screen.HomeScreen)
            })
//            Add habit Başlığı
            TextHeader("Select A Habit")

            LazyColumn(
                contentPadding = paddingValues,
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(state.habits){
                    habit ->
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = "${habit.habitName}", fontSize = 20.sp)
                            Text(text = "${habit.habitDescription}", fontSize = 12.sp)
                        }
                        IconButton(onClick = {
                            onEvent(HabitEvent.DeleteHabit(habit = habit))
                        }) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Delete contact"
                            )
                        }
                        
                    }
                }
            }
            
            
            
//            LazyColumn(
//                contentPadding = PaddingValues(all = 12.dp),
//                verticalArrangement = Arrangement.spacedBy(12.dp)
//            ){
//                itemsIndexed(items = getAllData){index, habit ->
//                    Log.d("MainActivity", "index: ${index.toString()}")
//                    CustomHabitLazyColum(habit = habit, onButtonClicked = {
//
//                    })
//                }
//            }
        }
//        altında Tanımlı olan popüler tüm alışkanlıkların listesi alt alta
//        liste içinde itemler image isim ve ekle tuşuyla birlikte tek bir rowda
//        en altta sabit add my own butonu var popüler alışkanlıkların dışında alışkanlık eklemek için

    }

}