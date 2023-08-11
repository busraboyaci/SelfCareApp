package com.busra.selfcareapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.busra.selfcareapp.components.ButtonComponent
import com.busra.selfcareapp.components.HeadingTextComponent
import com.busra.selfcareapp.data.SignUpViewModel

@Composable
fun HomeScreen(loginViewModel: SignUpViewModel = viewModel()) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            HeadingTextComponent(value = "Home")
            ButtonComponent(value = "Logout", onButtonClicked = {
                loginViewModel.logout()
            },
                isEnabled = true)
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}