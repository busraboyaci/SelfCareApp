package com.busra.selfcareapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.busra.selfcareapp.R
import com.busra.selfcareapp.components.ButtonComponent
import com.busra.selfcareapp.components.ClickableLoginTextComponent
import com.busra.selfcareapp.components.DividerTextComponent
import com.busra.selfcareapp.components.HeadingTextComponent
import com.busra.selfcareapp.components.MyTextComponent
import com.busra.selfcareapp.components.NormalTextComponent
import com.busra.selfcareapp.components.PasswordTextFieldComponent
import com.busra.selfcareapp.components.UnderLineTextComponent
import com.busra.selfcareapp.data.LoginViewModel
import com.busra.selfcareapp.data.UIEvent
import com.busra.selfcareapp.navigate.Screen
import com.busra.selfcareapp.navigate.SelfCareAppRouter
import com.busra.selfcareapp.navigate.SystemBackButtonHandler

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column (
            modifier = Modifier.fillMaxSize()
        ) {
            NormalTextComponent(value = stringResource(id = R.string.login))
            HeadingTextComponent(value = stringResource(id = R.string.welcome))
            Spacer(modifier = Modifier.height(20.dp))
            MyTextComponent(
                labelValue = stringResource(id = R.string.email),
                painterResource(id = R.drawable.email),
                onTextSelected = {
                    loginViewModel.onEvent(UIEvent.EmailChanged(it))
                }
            )
            PasswordTextFieldComponent(
                labelValue = stringResource(id = R.string.password),
                painterResource(id = R.drawable.password),
                onTextSelected = {
                    loginViewModel.onEvent(UIEvent.PasswordChanged(it))
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            UnderLineTextComponent(stringResource(id = R.string.forgot_password))
            Spacer(modifier = Modifier.height(20.dp))

            ButtonComponent(value = stringResource(id = R.string.login))
            Spacer(modifier = Modifier.height(20.dp))
            DividerTextComponent()

            ClickableLoginTextComponent(tryingToLogin = false, onTextSelected =  {
                SelfCareAppRouter.navigateTo(Screen.SignUpScreen)

            })

        }

    }
    SystemBackButtonHandler {
        SelfCareAppRouter.navigateTo(Screen.SignUpScreen)
    }
}


@Preview
@Composable
fun DefaultPreviewOfLoginScreen(){
    LoginScreen()
}