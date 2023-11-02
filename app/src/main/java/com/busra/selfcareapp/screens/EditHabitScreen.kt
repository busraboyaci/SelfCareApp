package com.busra.selfcareapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.busra.selfcareapp.HabitEvent
import com.busra.selfcareapp.HabitViewModel
import com.busra.selfcareapp.R
import com.busra.selfcareapp.components.EditHabitScreenTopRow
import com.busra.selfcareapp.components.EditHabitTextFieldComposable
import com.busra.selfcareapp.components.RoundedColorItem
import com.busra.selfcareapp.components.RoundedImageWithWhiteBackground
import com.busra.selfcareapp.components.cardColor
import com.busra.selfcareapp.components.describeHabitEdittext
import com.busra.selfcareapp.data.uievent.HabitUIEvent
import com.busra.selfcareapp.data.roomdb.HabitDbModel
import com.busra.selfcareapp.navigate.Screen
import com.busra.selfcareapp.navigate.SelfCareAppRouter
import com.busra.selfcareapp.navigate.SystemBackButtonHandler

@Composable
fun EditHabitScreen(
    selectedHabit: HabitDbModel,
    editHabitScreenViewModel: HabitViewModel = viewModel(),
) {
    val currentSelectedHabit by remember { mutableStateOf(selectedHabit) }
    // Renk değişikliği izlemek için bir MutableState kullanın
    val backgroundColorState = remember { mutableStateOf(currentSelectedHabit.backgroundColor) }


    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = currentSelectedHabit.backgroundColor))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(colorResource(id = currentSelectedHabit.backgroundColor))
                .padding(top = 10.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EditHabitScreenTopRow(
                backOnButtonClicked = {
                    SelfCareAppRouter.navigateTo(Screen.AddHabitScreen)
                },
                onButtonClicked = {
//                    add habit onclick to db
                    // Renk değiştiğinde arka plan rengini güncelleyin
                    editHabitScreenViewModel.habitUIEvent(HabitUIEvent.SetHabitBackground(backgroundColorState.value))
                    editHabitScreenViewModel.setSystemDefinedToFalse(currentSelectedHabit)

//                    LaunchedEffect(backgroundColorState.value) {
//                        editHabitScreenViewModel.habitUIEvent(HabitUIEvent.SetHabitBackground(backgroundColorState.value))
//                    }
                },
                selectedHabit = currentSelectedHabit.backgroundColor
            )
            // Seçili habit'a ait bilgileri Text olarak göster
            RoundedImageWithWhiteBackground(
                imageName = currentSelectedHabit.iconResName
            )
//            TODO: Textfield eklenecek

            EditHabitTextFieldComposable(
                selectedHabit = currentSelectedHabit,
                onTextSelected = {
                    editHabitScreenViewModel.habitUIEvent(HabitUIEvent.HabitNameChanged(it))
                }
            )
            Spacer(modifier = Modifier.height(5.dp))
            describeHabitEdittext(
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp)
                    .height(100.dp)
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(colorResource(id = backgroundColorState.value)),
                currentSelectedHabit.backgroundColor
            )

            cardColor(currentSelectedHabit.backgroundColor)
            Row {
                RoundedColorItem(R.color.cream_yellow, onClick = {
                    backgroundColorState.value = R.color.cream_yellow
                    currentSelectedHabit.backgroundColor = backgroundColorState.value
                    editHabitScreenViewModel.habitUIEvent(HabitUIEvent.SetHabitBackground(currentSelectedHabit.backgroundColor))
                    print("currentSelectedHabit.backgroundColor : "+currentSelectedHabit.backgroundColor)

                })
                RoundedColorItem(R.color.teal_200, onClick = {
                    backgroundColorState.value = R.color.teal_200
                    currentSelectedHabit.backgroundColor = backgroundColorState.value
                    editHabitScreenViewModel.habitUIEvent(HabitUIEvent.SetHabitBackground(R.color.teal_200))
                    print("currentSelectedHabit.backgroundColor : "+currentSelectedHabit.backgroundColor)
                })
                RoundedColorItem(R.color.light_pink, onClick = {
                    backgroundColorState.value = R.color.light_pink
                    currentSelectedHabit.backgroundColor = backgroundColorState.value
                    editHabitScreenViewModel.habitUIEvent(HabitUIEvent.SetHabitBackground(R.color.light_pink))
                    print("currentSelectedHabit.backgroundColor : "+currentSelectedHabit.backgroundColor)
                })
                RoundedColorItem(R.color.purple_500, onClick = {
                    backgroundColorState.value = R.color.purple_500
                    currentSelectedHabit.backgroundColor = backgroundColorState.value
                    editHabitScreenViewModel.habitUIEvent(HabitUIEvent.SetHabitBackground(R.color.purple_500))
                    print("currentSelectedHabit.backgroundColor : "+currentSelectedHabit.backgroundColor)
                })
                RoundedColorItem(R.color.soft_yellow, onClick = {
                    backgroundColorState.value = R.color.soft_yellow
                    currentSelectedHabit.backgroundColor = backgroundColorState.value
                    editHabitScreenViewModel.habitUIEvent(HabitUIEvent.SetHabitBackground(R.color.soft_yellow))
                    print("currentSelectedHabit.backgroundColor : "+currentSelectedHabit.backgroundColor)
                })
                RoundedColorItem(R.color.soft_pink, onClick = {
                    backgroundColorState.value = R.color.soft_pink
                    currentSelectedHabit.backgroundColor = R.color.soft_pink
                    editHabitScreenViewModel.habitUIEvent(HabitUIEvent.SetHabitBackground(R.color.soft_pink))
                    print("currentSelectedHabit.backgroundColor : "+currentSelectedHabit.backgroundColor)
                })
                RoundedColorItem(R.color.teal_700, onClick = {
                    backgroundColorState.value = R.color.teal_700
                    currentSelectedHabit.backgroundColor = R.color.teal_700
                    editHabitScreenViewModel.habitUIEvent(HabitUIEvent.SetHabitBackground(R.color.teal_700))
                    print("currentSelectedHabit.backgroundColor : "+currentSelectedHabit.backgroundColor)
                })
            }
//            TODO: seçilen ve değiştirilen habiti db update add butonuna tıklandığında
//            editHabitScreenViewModel.onEvent(HabitEvent.UpdateHabit(selectedHabit))
        }
    }

    SystemBackButtonHandler {
        SelfCareAppRouter.navigateTo(Screen.AddHabitScreen)
    }
}

