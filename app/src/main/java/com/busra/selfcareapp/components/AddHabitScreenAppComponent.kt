package com.busra.selfcareapp.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.busra.selfcareapp.R
import com.busra.selfcareapp.data.model.Habit
import com.busra.selfcareapp.data.repository.HabitRepository

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
fun ClickableLabel(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Tıklanabilir etiket oluşturma
    Text(
        text = text,
        fontSize = 16.sp,
        color = Color.Black,
        modifier = modifier
            .clickable { onClick.invoke() } // Tıklama işlevselliği ekleme
            .padding(8.dp), // Boşluk ekleme
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        )
    )
}
@Composable
fun EditHabitScreenTopRow(onButtonClicked: () -> Unit){
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
        Text(
            text = "Edit",
            fontSize = 16.sp,
            color = Color.Black,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal
            )
        )
        Spacer(modifier = Modifier.weight(1f))
        ClickableLabel("add", onButtonClicked)
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
fun TextHeader(text: String){
    Row (modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center){
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            fontSize = 20.sp
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

@Composable
fun CustomHabitLazyColum(habit: Habit, onButtonClicked: () -> Unit){
    Row (
        modifier = Modifier
            .background(colorResource(id = R.color.primary))
            .fillMaxWidth()
            .padding(24.dp)
            .clickable(onClick = onButtonClicked),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)

    ){
        Text(
            text = "${habit.habitIcon}",
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "${habit.habitDescription}",
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal
        )
    }
}




