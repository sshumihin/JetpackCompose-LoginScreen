package com.sss.jetpackcomposeloginregistration.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sss.jetpackcomposeloginregistration.R
import com.sss.jetpackcomposeloginregistration.components.HeadingTextComponent
import com.sss.jetpackcomposeloginregistration.navigation.PostOfficeAppRouter
import com.sss.jetpackcomposeloginregistration.navigation.Screen
import com.sss.jetpackcomposeloginregistration.navigation.SystemBackButtonHandler
import com.sss.jetpackcomposeloginregistration.ui.theme.WhiteColor

@Composable
fun TermsAndConditionsScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = WhiteColor)
            .padding(16.dp)
    ) {
        HeadingTextComponent(value = stringResource(id = R.string.terms_and_conditions_header))
    }

    SystemBackButtonHandler {
        PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
    }
}

@Preview
@Composable
fun TermsAndConditionsScreenPreview() {
    TermsAndConditionsScreen()
}