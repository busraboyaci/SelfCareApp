package com.busra.selfcareapp.data.rules

object Validator {

    fun validateFirstName(fName: String): ValidationResult{
        return ValidationResult(
            (!fName.isNullOrEmpty() && fName.length>=6)
        )
    }

    fun validateLastName(lName: String): ValidationResult{
        return ValidationResult(
            (!lName.isNullOrEmpty() && lName.length>=6)
        )
    }

    fun validateEmail(email: String): ValidationResult{
        return ValidationResult(
            (!email.isNullOrEmpty() && email.length>=6)
        )
    }

    fun validatePassword(password: String): ValidationResult{
        return ValidationResult(
            (!password.isNullOrEmpty() && password.length>=6)
        )
    }



}

data class ValidationResult(
    val status: Boolean = false
)