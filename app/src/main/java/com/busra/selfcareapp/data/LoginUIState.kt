package com.busra.selfcareapp.data

data class LoginUIState(
    var email: String = "",
    var password: String = "",
    var rememberMeCheckBoxClicked: Boolean = false,


    var emailError: Boolean = false,
    var passwordError: Boolean = false,
    var rememberMeError: Boolean = false

    )
