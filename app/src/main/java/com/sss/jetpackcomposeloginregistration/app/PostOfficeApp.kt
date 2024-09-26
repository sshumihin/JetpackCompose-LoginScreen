package com.sss.jetpackcomposeloginregistration.app


import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.sss.jetpackcomposeloginregistration.navigation.PostOfficeAppRouter
import com.sss.jetpackcomposeloginregistration.navigation.Screen
import com.sss.jetpackcomposeloginregistration.screens.LoginScreen
import com.sss.jetpackcomposeloginregistration.screens.SignUpScreen
import com.sss.jetpackcomposeloginregistration.screens.TermsAndConditionsScreen



@Composable
fun PostOfficeApp(innerPadding: PaddingValues) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        color = Color.White
    ) {
        Crossfade(targetState = PostOfficeAppRouter.currentScreen) { currentState ->
            when(currentState.value){
                is Screen.SignUpScreen ->{
                    SignUpScreen()
                }
                is Screen.TermsAndConditionsScreen ->{
                    TermsAndConditionsScreen()
                }
                is Screen.LoginScreen ->{
                    LoginScreen()
                }
            }
        }
    }
}