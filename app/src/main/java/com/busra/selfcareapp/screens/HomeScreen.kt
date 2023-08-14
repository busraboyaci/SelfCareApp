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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.busra.selfcareapp.components.HeadingTextComponent
import com.busra.selfcareapp.components.NormalTextComponent
import com.busra.selfcareapp.components.ProfileImage
import com.busra.selfcareapp.components.UserInformationTopBar
import com.busra.selfcareapp.data.SignUpViewModel
import com.busra.selfcareapp.data.datastore.UserSettingsManager
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

@Composable
fun HomeScreen(loginViewModel: SignUpViewModel = viewModel()) {
//    context
    val context = LocalContext.current
    var scope = rememberCoroutineScope()
    val dataStore = UserSettingsManager(context)
    val userName = FirebaseAuth.getInstance().currentUser?.email?.substringBefore("@")

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 10.dp)) {
            if (userName != null) {
                UserInformationTopBar(userName)
            }
        }




//            ButtonComponent(
//                value = "Logout", onButtonClicked = {
//                    loginViewModel.logout()
//                    scope.launch {
//                        dataStore.setCheckboxValue(false)
//                    }
//                },
//                isEnabled = true
//            )

    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}