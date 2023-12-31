package com.busra.selfcareapp.data.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.busra.selfcareapp.data.uievent.LoginUIEvent
import com.busra.selfcareapp.data.uistate.LoginUIState
import com.busra.selfcareapp.data.rules.Validator
import com.busra.selfcareapp.navigate.Screen
import com.busra.selfcareapp.navigate.SelfCareAppRouter
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel(): ViewModel() {
    private val TAG = LoginViewModel::class.simpleName
    var loginUIState = mutableStateOf(LoginUIState())
    var allValidationsPassed = mutableStateOf(false)
    var loginInProgress = mutableStateOf(false)
    var rememberMeIsChecked = mutableStateOf(false)
    fun onEvent(event: LoginUIEvent) {

        when (event) {
            is LoginUIEvent.EmailChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    email = event.email
                )
            }

            is LoginUIEvent.PasswordChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    password = event.password
                )
            }

            is LoginUIEvent.LoginButtonClicked -> {
                login()
            }

            is LoginUIEvent.RememberMeCheckBoxClicked ->{
                loginUIState.value = loginUIState.value.copy(
                    rememberMeCheckBoxClicked = event.status
                )
            }

        }
        validateLoginUIDataWithRules()
    }

//    private fun login() {
//        loginInProgress.value = true
//        val email = loginUIState.value.email
//        val password = loginUIState.value.password
//        FirebaseAuth
//            .getInstance()
//            .signInWithEmailAndPassword(email, password)
//            .addOnCompleteListener{
//                loginInProgress.value = false
//                Log.d(TAG, "login_success_addOnCompleteListener")
//                Log.d(TAG, "${it.isSuccessful}")
//                if (it.isSuccessful){
//                    SelfCareAppRouter.navigateTo(Screen.HomeScreen)
//                    Log.d(TAG, "isSuccessful in")
//                }
//            }
//            .addOnFailureListener{
//                Log.d(TAG, "login_failure")
//                Log.d(TAG, "${it.localizedMessage}")
//                rememberMeIsChecked.value = false
//            }
//
//    }

    private fun login() {
        loginInProgress.value = true
        val email = loginUIState.value.email
        val password = loginUIState.value.password

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                loginInProgress.value = false
                if (task.isSuccessful) {
                    Log.d(TAG, "login_success router")
                    SelfCareAppRouter.navigateTo(Screen.HomeScreen)
                }
            }
            .addOnFailureListener { exception ->
                loginInProgress.value = false
                Log.d(TAG, "login_failure")
                Log.d(TAG, "${exception.localizedMessage}")

                if (loginUIState.value.rememberMeCheckBoxClicked) {
                    // The "Remember Me" checkbox is checked, but the login failed.
                    // Handle this case here, e.g., show an error message.
                    Log.d(TAG, "login_failure")
                }
            }
    }

    private fun validateLoginUIDataWithRules(){
        val emailResult = Validator.validateEmail(
            email = loginUIState.value.email
        )

        val passwordResult = Validator.validatePassword(

            password = loginUIState.value.password
        )

        val rememberMeResult = Validator.rememberMeChecked(
            statusValue = loginUIState.value.rememberMeCheckBoxClicked
        )
        loginUIState.value = loginUIState.value.copy(
            emailError = emailResult.status,
            passwordError = passwordResult.status,
            rememberMeError = passwordResult.status,
        )

        allValidationsPassed.value = emailResult.status && passwordResult.status

        rememberMeIsChecked.value = rememberMeResult.status
    }


    fun setCheckboxValue(value: Boolean){

    }
}