package com.busra.selfcareapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.busra.selfcareapp.R
import com.busra.selfcareapp.components.AddHabitScreenTopRow
import com.busra.selfcareapp.navigate.ObserveScreenChanges
import com.busra.selfcareapp.navigate.Screen
import com.busra.selfcareapp.navigate.SelfCareAppRouter

@Composable
fun AddHabitScreen() {

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
            ObserveScreenChanges()

        }
//        altında Tanımlı olan popüler tüm alışkanlıkların listesi alt alta
//        liste içinde itemler image isim ve ekle tuşuyla birlikte tek bir rowda
//        en altta sabit add my own butonu var popüler alışkanlıkların dışında alışkanlık eklemek için

    }

}