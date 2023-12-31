package com.busra.selfcareapp.data.uievent

open class LoginUIEvent {
    data class EmailChanged(val email: String): LoginUIEvent()
    data class PasswordChanged(val password: String): LoginUIEvent()
    data class RememberMeCheckBoxClicked(val status: Boolean): LoginUIEvent()

    object LoginButtonClicked : LoginUIEvent()

}