package com.sss.jetpackcomposeloginregistration.data

data class RegistrationUIState (
    var firstName:String = "",
    var secondName:String = "",
    var email:String = "",
    var password:String = "",

    var firstNameError:Boolean = false,
    var lastNameError:Boolean = false,
    var emailError:Boolean = false,
    var passwordError:Boolean = false
)