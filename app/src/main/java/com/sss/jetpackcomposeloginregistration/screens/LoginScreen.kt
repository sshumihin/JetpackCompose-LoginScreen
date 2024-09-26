package com.sss.jetpackcomposeloginregistration.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sss.jetpackcomposeloginregistration.R
import com.sss.jetpackcomposeloginregistration.components.ButtonComponent
import com.sss.jetpackcomposeloginregistration.components.ClickableRegisterTextComponent
import com.sss.jetpackcomposeloginregistration.components.DividerTextComponent
import com.sss.jetpackcomposeloginregistration.components.HeadingTextComponent
import com.sss.jetpackcomposeloginregistration.components.MyTextFieldComponent
import com.sss.jetpackcomposeloginregistration.components.NormalTextComponent
import com.sss.jetpackcomposeloginregistration.components.PasswordTextFieldComponent
import com.sss.jetpackcomposeloginregistration.components.UnderLinedTextComponent
import com.sss.jetpackcomposeloginregistration.data.LoginViewModel
import com.sss.jetpackcomposeloginregistration.data.UIEvent
import com.sss.jetpackcomposeloginregistration.navigation.PostOfficeAppRouter
import com.sss.jetpackcomposeloginregistration.navigation.Screen

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()) {
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .padding(28.dp)
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            NormalTextComponent(value = stringResource(id = R.string.login))
            HeadingTextComponent(value = stringResource(id = R.string.welcome))
            Spacer(modifier = Modifier.height(20.dp))

            MyTextFieldComponent(
                labelValue = stringResource(id = R.string.email),
                painterResource(id = R.drawable.email),
                onTextSelected = {
                    loginViewModel.onEvent(UIEvent.EmailChanged(it))
                },
                errorStatus = loginViewModel.registrationUIState.value.emailError
            )

            PasswordTextFieldComponent(
                labelValue = stringResource(id = R.string.password),
                painterResource(id = R.drawable.lock),
                onTextSelected = {
                    loginViewModel.onEvent(UIEvent.PasswordChanged(it))
                },
                errorStatus = loginViewModel.registrationUIState.value.passwordError
            )

            Spacer(modifier = Modifier.height(20.dp))

            UnderLinedTextComponent(value = stringResource(R.string.forgot_password))

            Spacer(modifier = Modifier.height(40.dp))

            ButtonComponent(value = stringResource(id = R.string.login),
                onButtonClicked = {
                    loginViewModel.onEvent(UIEvent.LoginButtonClicked)
                })

            Spacer(modifier = Modifier.height(20.dp))

            DividerTextComponent()

            ClickableRegisterTextComponent(onTextSelected = {
                PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
            })
        }
    }

   /* SystemBackButtonHandler {
        PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
    }*/
}

@Preview
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}