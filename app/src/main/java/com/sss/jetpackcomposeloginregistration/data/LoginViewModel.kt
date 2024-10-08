package com.sss.jetpackcomposeloginregistration.data

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.sss.jetpackcomposeloginregistration.data.rules.Validator

class LoginViewModel : ViewModel() {
    private val TAG = LoginViewModel::class.simpleName

    var registrationUIState = mutableStateOf(RegistrationUIState())

    fun onEvent(event: UIEvent) {
        validateDataWithRules()
        when (event) {
            is UIEvent.FirstNameChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    firstName = event.firstName
                )

                printState()
            }

            is UIEvent.LastNameChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    secondName = event.lastName
                )

                printState()
            }

            is UIEvent.EmailChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    email = event.email
                )

                printState()
            }

            is UIEvent.PasswordChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    password = event.password
                )

                printState()
            }

            is UIEvent.RegisterButtonClicked -> {
                signUp()
            }

            is UIEvent.LoginButtonClicked -> {
                login()
            }
        }
    }

    private fun login() {

    }

    private fun signUp() {
        Log.d(TAG, "Inside signUp")
        printState()

        validateDataWithRules()
    }

    private fun validateDataWithRules() {
        val fNameResult = Validator.validateFirstName(
            fName = registrationUIState.value.firstName
        )

        val lNameResult = Validator.validateLastName(
            lName = registrationUIState.value.secondName
        )

        val emailResult = Validator.validateEmail(
            email = registrationUIState.value.email
        )

        val passwordResult = Validator.validatePassword(
            password = registrationUIState.value.password
        )

        Log.d(TAG, "Inside validateDataWithRules")
        Log.d(TAG, "fNameResult=$fNameResult")
        Log.d(TAG, "lNameResult=$lNameResult")
        Log.d(TAG, "emailResult=$emailResult")
        Log.d(TAG, "passwordResult=$passwordResult")

        registrationUIState.value = registrationUIState.value.copy(
            firstNameError = fNameResult.status,
            lastNameError = lNameResult.status,
            emailError = emailResult.status,
            passwordError = passwordResult.status
        )
    }

    private fun printState() {
        Log.d(TAG, "Inside printState")
        Log.d(TAG, registrationUIState.value.toString())
    }
}