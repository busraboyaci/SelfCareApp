package com.busra.selfcareapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.busra.selfcareapp.R
import com.busra.selfcareapp.data.SignUpViewModel
import com.busra.selfcareapp.ui.Primary
import com.busra.selfcareapp.ui.Secondary
import kotlinx.coroutines.launch

@Composable
fun UserInformationTopBar(userName: String, onButtonClicked: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(color = colorResource(id = R.color.primary)),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        ProfileImage()

        Column(
            modifier = Modifier
                .width(80.dp)
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
//        NotificationImageButton()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .clickable(onClick = onButtonClicked),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            LogoutButtonComponent(onButtonClicked = onButtonClicked)
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

@Composable
fun LogoutButtonComponent(onButtonClicked: () -> Unit) {
    Box(
        modifier = Modifier
            .width(48.dp)
            .heightIn(48.dp)
            .clickable(onClick = onButtonClicked),
        contentAlignment = Alignment.BottomEnd
    ) {
        Icon(
            painter = painterResource(id = R.drawable.notification),
            contentDescription = "logout",
            modifier = Modifier
                .size(48.dp), // İstediğiniz boyutu ayarlayabilirsiniz
//                .border(1.dp, Color.Gray, shape = RoundedCornerShape(50.dp)) // Kenarlık ekledik
//                .padding(8.dp) // Icon etrafında boşluk bırakmak için
            tint = Color.White
        )
    }
}
//@Composable
//fun LogoutButtonComponent( onButtonClicked: () ->Unit) {
//    Button(
//        modifier = Modifier
//            .fillMaxWidth()
//            .heightIn(48.dp),
//        onClick ={
//            onButtonClicked.invoke()
//        },
//        contentPadding = PaddingValues(),
//        colors = ButtonDefaults.buttonColors(Color.Transparent),
//        shape = RoundedCornerShape(50.dp),
//    ){
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .heightIn(48.dp)
//                .background(
//                    Color.Transparent
////                    brush = Brush.horizontalGradient(listOf(Secondary, Primary)),
////                    shape = RoundedCornerShape(50.dp)
//                ),
//            contentAlignment = Alignment.Center
//        ) {
//            Icon(painter = painterResource(id = R.drawable.notification), contentDescription = "logout", )
//        }
//    }
//}

//@Composable
//fun NotificationImage(){
//    Row(modifier = Modifier
//        .fillMaxWidth(),
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.End,
//
//        ) {
//        // Diğer içerikler
//        Image(
//            painter = painterResource(id = R.drawable.notification),
//            contentDescription = "Image",
//            modifier = Modifier
//                .size(40.dp),
//
//        )
//    }

//@Composable
//fun NotificationImageButton() {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth(),
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.End,
//    ) {
//        // Diğer içerikler
//
//        Button(
//            onClick = {
//
//            },
//            modifier = Modifier
//                .size(40.dp)
//                .background(Color.Transparent)
//        ) {
//            // Button içeriği
//            // Icon eklemek için Image kompozisyonu kullanabilirsiniz
//            Image(
//                painter = painterResource(id = R.drawable.notification),
//                contentDescription = "Image",
//                modifier = Modifier.size(24.dp) // Icon boyutunu ayarlayabilirsiniz
//            )
//        }
//    }
//}


//    Image(
//        painter = painterResource(R.drawable.notification),
//        contentDescription = "avatar",
//        contentScale = ContentScale.Crop,       // crop the image if it's not a square
//        modifier = Modifier
//            .size(44.dp)
//            .align(Alignment.BottomCenter)
//    )
//}


