package com.busra.selfcareapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun UserInformationTopBar(userName: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(color = colorResource(id = R.color.primary)),
        verticalAlignment = Alignment.Top
    ) {
        ProfileImage()
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Text(
                text = "Hello ,",
                style = TextStyle(fontSize = 12.sp, color = Color.Gray),
                color = Color.White
            )
            Text(
                text = userName,
                style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold),
                color = Color.White,
                modifier = Modifier.padding(bottom = 4.dp)
            )
//           yanına eklemen gerekenleri ekle ayarlar kebab menu vs
        }
    }

}

@Composable
fun ProfileImage() {
    Image(
        painter = painterResource(R.drawable.rabbit),
        contentDescription = "avatar",
        contentScale = ContentScale.Crop,       // crop the image if it's not a square
        modifier = Modifier
            .size(74.dp)
            .clip(CircleShape)                       // clip to the circle shape
            .border(
                2.dp,
                colorResource(id = R.color.primary),
                CircleShape
            )   // add a border (optional)
            .background(colorResource(id = R.color.white))
    )
}