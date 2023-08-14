package com.busra.selfcareapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import com.busra.selfcareapp.components.RememberMeCheckboxComponent
import com.busra.selfcareapp.components.UnderLineTextComponent
import com.busra.selfcareapp.data.LoginUIEvent
import com.busra.selfcareapp.data.LoginViewModel
import com.busra.selfcareapp.data.SignUpViewModel
import com.busra.selfcareapp.data.SignUpUIEvent
import com.busra.selfcareapp.data.datastore.UserSettingsManager
import com.busra.selfcareapp.navigate.Screen
import com.busra.selfcareapp.navigate.SelfCareAppRouter
import com.busra.selfcareapp.navigate.SystemBackButtonHandler
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()) {
//    context
    var context = LocalContext.current
//    scope
    var scope = rememberCoroutineScope()
//    dataStore
    var dataStore = UserSettingsManager(context)
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                NormalTextComponent(value = stringResource(id = R.string.login))
                HeadingTextComponent(value = stringResource(id = R.string.welcome))
                Spacer(modifier = Modifier.height(20.dp))
                MyTextComponent(
                    labelValue = stringResource(id = R.string.email),
                    painterResource(id = R.drawable.email),
                    onTextSelected = {
                        loginViewModel.onEvent(LoginUIEvent.EmailChanged(it))
                    },
                    errorStatus = loginViewModel.loginUIState.value.emailError
                )
                PasswordTextFieldComponent(
                    labelValue = stringResource(id = R.string.password),
                    painterResource(id = R.drawable.password),
                    onTextSelected = {
                        loginViewModel.onEvent(LoginUIEvent.PasswordChanged(it))
                    },
                    errorStatus = loginViewModel.loginUIState.value.passwordError
                )

                RememberMeCheckboxComponent(onCheckedChange = {
                    loginViewModel.onEvent(LoginUIEvent.RememberMeCheckBoxClicked(it))
                })

                Spacer(modifier = Modifier.height(120.dp))

                ButtonComponent(
                    value = stringResource(id = R.string.login),
                    onButtonClicked = {
                        loginViewModel.onEvent(LoginUIEvent.LoginButtonClicked)
                        scope.launch {
                            dataStore.setCheckboxValue(loginViewModel.rememberMeIsChecked.value)
                        }
                    },
                    isEnabled = loginViewModel.allValidationsPassed.value,
                )
                Spacer(modifier = Modifier.height(20.dp))
                DividerTextComponent()

                ClickableLoginTextComponent(tryingToLogin = false, onTextSelected = {
                    SelfCareAppRouter.navigateTo(Screen.SignUpScreen)

                })
            }
        }
        if (loginViewModel.loginInProgress.value) {
            CircularProgressIndicator()
        }
    }

    SystemBackButtonHandler {
        SelfCareAppRouter.navigateTo(Screen.SignUpScreen)
    }
}


@Preview
@Composable
fun DefaultPreviewOfLoginScreen() {
    LoginScreen()
}