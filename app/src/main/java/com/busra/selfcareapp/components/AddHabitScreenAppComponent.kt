package com.busra.selfcareapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.busra.selfcareapp.R

@Composable
fun AddHabitScreenTopRow(onButtonClicked: () -> Unit){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.cream))
            .padding(8.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(color = colorResource(id = R.color.cream)),
        verticalAlignment = Alignment.CenterVertically,
    ){
        BackImageButton(onButtonClicked = onButtonClicked, R.drawable.back)
        Spacer(modifier = Modifier.weight(1f))
        SearchImageButton()
    }
}

@Composable
fun BackImageButton(onButtonClicked: () -> Unit, drawable: Int) {
    Box(
        modifier = Modifier
            .width(34.dp)
            .heightIn(34.dp)
            .clickable(onClick = onButtonClicked),
        contentAlignment = Alignment.BottomStart
    ) {
        Icon(
            painter = painterResource(id = drawable),
            contentDescription = "logout",
            modifier = Modifier
                .size(34.dp), // İstediğiniz boyutu ayarlayabilirsiniz
//                .border(1.dp, Color.Gray, shape = RoundedCornerShape(50.dp)) // Kenarlık ekledik
//                .padding(8.dp) // Icon etrafında boşluk bırakmak için
            tint = colorResource(id = R.color.darkGray)
        )
    }
}

@Composable
fun SearchImageButton(){
    Box(
        modifier = Modifier
            .width(34.dp)
            .heightIn(34.dp)
            .clickable(onClick = {})
    ){
        Icon(
            painter = painterResource(id = R.drawable.search),
            contentDescription = "search",
            modifier = Modifier
                .size(34.dp)
                .align(Alignment.CenterEnd),
            tint = colorResource(id = R.color.darkGray)
        )
    }
}

@Preview
@Composable
fun PreviewAddHabitScreen(){
    AddHabitScreenTopRow(onButtonClicked = {})
}