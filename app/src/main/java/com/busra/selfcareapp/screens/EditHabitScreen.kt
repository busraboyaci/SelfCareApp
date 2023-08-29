package com.busra.selfcareapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.busra.selfcareapp.HabitEvent
import com.busra.selfcareapp.HabitViewModel
import com.busra.selfcareapp.R
import com.busra.selfcareapp.components.EditHabitScreenTopRow
import com.busra.selfcareapp.components.EditHabitTextFieldComposable
import com.busra.selfcareapp.components.RoundedImageWithWhiteBackground
import com.busra.selfcareapp.data.HabitUIEvent
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
//        column  ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(colorResource(id = R.color.purple_soft))
                .padding(top = 10.dp),
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

//            TODO: seçilen ve değiştirilen habiti db update
//            editHabitScreenViewModel.onEvent(HabitEvent.UpdateHabit(selectedHabit))

//            Image(
//                painter = painterResource(
//                    id = LocalContext.current.resources.getIdentifier(
//                        selectedHabit.iconResName,
//                        "drawable",
//                        LocalContext.current.packageName
//                    )
//                ),
//                contentDescription = null, // İconların genellikle content description'ı olmaz
//                modifier = Modifier
//                    .size(48.dp)
//                    .padding(end = 5.dp)
//            )


//            Text(text = "Habit Name: ${selectedHabit.habitName}")
//            Text(text = "Habit Description: ${selectedHabit.habitDescription}")
//            Text(text = "Icon Resource: ${selectedHabit.iconResName}")

            // Gerekli diğer bileşenleri ekleyebilirsiniz
        }
    }

    SystemBackButtonHandler {
        SelfCareAppRouter.navigateTo(Screen.AddHabitScreen)
    }
}