package com.busra.selfcareapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.busra.selfcareapp.HabitEvent
import com.busra.selfcareapp.HabitViewModel
import com.busra.selfcareapp.R
import com.busra.selfcareapp.components.AddHabitScreenTopRow
import com.busra.selfcareapp.components.HabitDesign
import com.busra.selfcareapp.components.TextHeader
import com.busra.selfcareapp.navigate.Screen
import com.busra.selfcareapp.navigate.SelfCareAppRouter
import com.busra.selfcareapp.navigate.SystemBackButtonHandler


@Composable
fun AddHabitScreen(
    viewModel: HabitViewModel,
    onEvent: (HabitEvent) -> Unit,
) {
//    val habitRepository = HabitRepository()
//    val getAllData = habitRepository.getAllData()
    val state = viewModel.state
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.cream))
    ) {
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
                contentPadding = PaddingValues(8.dp),
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),

                ) {
                items(state.value.habits) { habit ->
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .wrapContentHeight()
//                            .padding(vertical = 10.dp)
//                            .clickable(onClick = {
//                                onEvent(HabitEvent.SelectHabit(habit)) // Seçili öğeyi güncelleme olayını tetikle
//                                SelfCareAppRouter.navigateTo(Screen.EditHabitScreen)
//                            }),
//                        horizontalArrangement = Arrangement.Center,
//                    ) {
//                        Column(
//                            modifier = Modifier
//                                .weight(0.1f)
//                                .clip(shape = RoundedCornerShape(15.dp))
//                                .background(colorResource(id = habit.backgroundColor))
//                        ) {
//                            Spacer(modifier = Modifier.height(5.dp))
//                            Row(
//                                horizontalArrangement = Arrangement.SpaceBetween, // Aligns items horizontally with space between
//                                verticalAlignment = Alignment.CenterVertically
//                            ){
//                                Spacer(modifier = Modifier.width(5.dp))
//                                Image(
//                                    painter = painterResource(
//                                        id = LocalContext.current.resources.getIdentifier(
//                                            habit.iconResName,
//                                            "drawable",
//                                            LocalContext.current.packageName
//                                        )
//                                    ),
//                                    contentDescription = null, // Iconların genellikle content description'ı olmaz
//                                    modifier = Modifier
//                                        .size(48.dp)
//                                        .padding(end = 5.dp)
//                                )
//                                Text(
//                                    text = "${habit.habitName}",
//                                    fontSize = 25.sp,
//                                    textAlign = TextAlign.Start,
//                                    modifier = Modifier
//                                        .weight(1f) // Yatayda tam genişlik
//                                        .padding(start = 16.dp), // Sol kenardan boşluk
//                                )
//                                Text(
//                                    text = "${habit.systemDefined}",
//                                    fontSize = 25.sp,
//                                )
//                            }
//                            Spacer(modifier = Modifier.height(5.dp))
//                        }
//
                    HabitDesign(habit, onEvent, Icons.Default.AddCircle)
                }
            }
        }

    }

    SystemBackButtonHandler {
        SelfCareAppRouter.navigateTo(Screen.HomeScreen)
    }

}