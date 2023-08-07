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
import com.busra.selfcareapp.components.CheckboxComponent
import com.busra.selfcareapp.components.ClickableLoginTextComponent
import com.busra.selfcareapp.components.DividerTextComponent
import com.busra.selfcareapp.components.HeadingTextComponent
import com.busra.selfcareapp.components.MyTextComponent
import com.busra.selfcareapp.components.NormalTextComponent
import com.busra.selfcareapp.components.PasswordTextFieldComponent
import com.busra.selfcareapp.data.LoginViewModel
import com.busra.selfcareapp.data.UIEvent
import com.busra.selfcareapp.navigate.Screen
import com.busra.selfcareapp.navigate.SelfCareAppRouter


@Composable
fun SignUpScreen(loginViewModel: LoginViewModel = viewModel()) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            NormalTextComponent(value = stringResource(id = R.string.hello))
            HeadingTextComponent(value = stringResource(id = R.string.create_account))
            Spacer(modifier = Modifier.height(20.dp))
            MyTextComponent(
                labelValue = stringResource(id = R.string.firstname),
                painterResource(id = R.drawable.person),
                onTextSelected = {
                    loginViewModel.onEvent(UIEvent.FirstNameChanged(it))
                }
            )
            MyTextComponent(
                labelValue = stringResource(id = R.string.lastname),
                painterResource(id = R.drawable.person),
                onTextSelected = {
                    loginViewModel.onEvent(UIEvent.LastNameChanged(it))
                }
            )
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


            CheckboxComponent(value = stringResource(id = R.string.terms_and_conditions),
                onTextSelected = {
                    SelfCareAppRouter.navigateTo(Screen.TermsAndConditionScreen)
                })
            Spacer(modifier = Modifier.height(80.dp))

            ButtonComponent(value = stringResource(id = R.string.register))

            Spacer(modifier = Modifier.height(20.dp))

            DividerTextComponent()

            ClickableLoginTextComponent(tryingToLogin = true, onTextSelected =  {
                SelfCareAppRouter.navigateTo(Screen.LoginScreen)
            })

        }

    }
}

@Preview
@Composable
fun DefaultPreviewOfSignUpScreen() {
    SignUpScreen()
}