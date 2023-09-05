package com.busra.selfcareapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.busra.selfcareapp.HabitViewModel
import com.busra.selfcareapp.R
import com.busra.selfcareapp.components.EditHabitScreenTopRow
import com.busra.selfcareapp.components.EditHabitTextFieldComposable
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
    editHabitScreenViewModel: HabitViewModel = viewModel()
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.purple_soft))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(colorResource(id = R.color.purple_soft))
                .padding(top = 10.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EditHabitScreenTopRow(onButtonClicked = {
                SelfCareAppRouter.navigateTo(Screen.AddHabitScreen)
            })
            // Seçili habit'a ait bilgileri Text olarak göster
            RoundedImageWithWhiteBackground(
                imageName = selectedHabit.iconResName
            )
//            TODO: Textfield eklenecek

            EditHabitTextFieldComposable(
                selectedHabit = selectedHabit,
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
                    .background(colorResource(id = R.color.light_pink))
            )

            cardColor()
//            TODO: seçilen ve değiştirilen habiti db update add butonuna tıklandığında
//            editHabitScreenViewModel.onEvent(HabitEvent.UpdateHabit(selectedHabit))
        }
    }

    SystemBackButtonHandler {
        SelfCareAppRouter.navigateTo(Screen.AddHabitScreen)
    }
}

