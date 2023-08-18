package com.busra.selfcareapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.busra.selfcareapp.R

@Composable
fun UserInformationTopBar(userName: String, onNotificationButtonClick: () -> Unit, onMenuButtonClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.cream))
            .padding(8.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(color = colorResource(id = R.color.cream)),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        ProfileImage()
        Spacer(modifier = Modifier.width(15.dp))
        Column(
            modifier = Modifier
                .width(150.dp)
        ) {

            Text(
                text = "Hello ,",
                style = TextStyle(fontSize = 18.sp, color = Color.Gray),
                color = colorResource(id = R.color.darkGray),
            )
            Text(
                text = userName,
                style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
                color = colorResource(id = R.color.smBlack),
                modifier = Modifier.padding(bottom = 4.dp)
            )
//           yanına eklemen gerekenleri ekle ayarlar kebab menu vs
        }
//        NotificationImageButton()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .clickable(onClick = {}),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            ImageButtonComponent(onButtonClicked = onNotificationButtonClick, R.drawable.notification)
            Spacer(modifier = Modifier.width(10.dp))
            ImageButtonComponent(onButtonClicked = onMenuButtonClick, R.drawable.hamburger_menu)
            Spacer(modifier = Modifier.width(10.dp))

        }

    }

}

@Composable
fun ProfileImage() {

    Image(
        painter = painterResource(R.drawable.person),
        contentDescription = "avatar",
        contentScale = ContentScale.Crop, // crop the image if it's not a square
        modifier = Modifier
            .size(64.dp)
            .clip(CircleShape)                       // clip to the circle shape
            .border(
                2.dp,
                colorResource(id = R.color.white),
                CircleShape
            )   // add a border (optional)
            .background(colorResource(id = R.color.profile_photo_bg))
    )
}

@Composable
fun ImageButtonComponent(onButtonClicked: () -> Unit, drawable: Int) {
    Box(
        modifier = Modifier
            .width(34.dp)
            .heightIn(34.dp)
            .clickable(onClick = onButtonClicked),
        contentAlignment = Alignment.BottomEnd
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


