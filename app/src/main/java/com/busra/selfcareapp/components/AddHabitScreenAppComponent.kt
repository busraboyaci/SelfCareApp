package com.busra.selfcareapp.components

import android.text.Layout
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Switch
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.busra.selfcareapp.R
import com.busra.selfcareapp.data.roomdb.HabitDbModel
import com.busra.selfcareapp.ui.GrayColor
import com.busra.selfcareapp.ui.HalfGray
import com.google.android.material.color.ColorResourcesOverride

@Composable
fun AddHabitScreenTopRow(onButtonClicked: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.cream))
            .padding(8.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(color = colorResource(id = R.color.cream)),
        verticalAlignment = Alignment.CenterVertically,
    ) {
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
            .clickable {
                onClick.invoke()
            } // Tıklama işlevselliği ekleme
            .padding(8.dp), // Boşluk ekleme
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),

    )
}

@Composable
fun EditHabitScreenTopRow(onButtonClicked: () -> Unit, backOnButtonClicked: () -> Unit, selectedHabit: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = selectedHabit))
            .padding(8.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(color = colorResource(id = selectedHabit)),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        BackImageButton(onButtonClicked = backOnButtonClicked, R.drawable.back)
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
fun TextHeader(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            fontSize = 20.sp
        )
    }

}

@Composable
fun SearchImageButton() {
    Box(
        modifier = Modifier
            .width(34.dp)
            .heightIn(34.dp)
            .clickable(onClick = {})
    ) {
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
fun RoundedImageWithWhiteBackground(
    imageName: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .padding(10.dp)
            .clip(RoundedCornerShape(16.dp))
            .size(78.dp)
            .background(colorResource(id = R.color.cream)),
        contentAlignment = Alignment.Center

    ) {
        Image(
            painter = painterResource(
                id = LocalContext.current.resources.getIdentifier(
                    imageName,
                    "drawable",
                    LocalContext.current.packageName
                )
            ),
            contentDescription = null, // Iconların genellikle content description'ı olmaz
            modifier = Modifier
                .size(48.dp)
        )
    }
}


@Composable
fun EditHabitTextFieldComposable(
    modifier: Modifier = Modifier,
    onTextSelected: (String) -> Unit,
    selectedHabit: HabitDbModel,
) {
    val textValue = remember {
        mutableStateOf(selectedHabit.habitName)
    }
    TextField(
        modifier = modifier.background(Color.Transparent),
        value = textValue.value,
        onValueChange = {
            textValue.value = it
            onTextSelected(it)
        },
        textStyle = LocalTextStyle.current.copy(
            textAlign = TextAlign.Center, fontSize = 40.sp, fontWeight = FontWeight.Bold,
        ),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = colorResource(id = selectedHabit.backgroundColor),
            unfocusedIndicatorColor = colorResource(id = R.color.black),
            focusedIndicatorColor = colorResource(id = R.color.black),
        ),
    )

}

@Composable
fun describeHabitEdittext(modifier: Modifier, selectedHabit: Int) {
    val numOfChar = 0
    Column(
//        modifier = Modifier
//            .clip(shape = RoundedCornerShape(15.dp))
//            .background(colorResource(id = R.color.light_pink))
    ) {
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = selectedHabit))
                .padding(8.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                .background(color = colorResource(id = selectedHabit)),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Describe",
                fontSize = 16.sp,
                color = Color.Black,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal
                )
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "${numOfChar}/200",
                fontSize = 16.sp,
                color = colorResource(id = R.color.soft_grey),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal
                )
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween, // Aligns items horizontally with space between
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(5.dp))
            val textValue = remember {
                mutableStateOf("")
            }
            TextField(
                modifier = modifier.background(Color.Transparent),
                value = textValue.value,
                onValueChange = {
                    textValue.value = it
//                    onTextSelected(it)
                },
                textStyle = LocalTextStyle.current.copy(
                    textAlign = TextAlign.Start, fontSize = 16.sp, fontWeight = FontWeight.Bold,
                ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = colorResource(id = R.color.cream),
                    unfocusedIndicatorColor = colorResource(id = R.color.cream),
                    focusedIndicatorColor = colorResource(id = R.color.cream),
                ),
            )
        }
    }

}

@Composable
fun cardColor(
    selectedHabit: Int
) {
    Column (modifier = Modifier
        .fillMaxWidth()
    ){
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = selectedHabit))
                .padding(8.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                .background(color = colorResource(id = selectedHabit)),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Card Color",
                fontSize = 16.sp,
                color = Color.Black,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal
                )
            )
        }
    }

}

@Composable
fun RoundedColorItem(color: Int, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(55.dp)
            .padding(8.dp)
            .border(3.dp, Color.White, shape = CircleShape) // Beyaz kenarlık eklemek için
            .background(colorResource(color), shape = CircleShape)
            .clickable { onClick() } // Tıklama özelliği ekleniyor
    )
}

@Composable
fun RepeatScreen(modifier: Modifier) {
    val mCheckedState = remember{ mutableStateOf(false)}

    Column (
        modifier = modifier,
    ){
        Text(
            text = "Repeat",
            fontSize = 16.sp,
            color = Color.Black,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal
            ),
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.width(5.dp))
        Column (
            modifier = Modifier
                .clip(shape = RoundedCornerShape(20.dp))
                .fillMaxWidth()
                .height(150.dp)
                .background(Color.White),
        ){
            Row (
                verticalAlignment = Alignment.CenterVertically,
                ){
                Spacer(modifier = Modifier.width(5.dp))
                Icon(
                    painter = painterResource(id = R.drawable.baseline_event_repeat_24),
                    contentDescription = "repeat",
                    modifier = Modifier
                        .size(25.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(  text = "Repeat",
                    fontSize = 16.sp,
                    color = HalfGray,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Normal
                    )
                )
                Spacer(modifier = Modifier.weight(1f))
                Switch(checked = mCheckedState.value, onCheckedChange = {mCheckedState.value = it})
            }
            DrawThinLine(modifier)
        }


    }
}

@Composable
fun DrawThinLine(modifier: Modifier) {
    // Ince çizgiyi çizmek için Box kullanabiliriz.
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .height(1.dp) // Çizgi yüksekliği
                .fillMaxSize()
                .background(GrayColor)
        )
    }
}



