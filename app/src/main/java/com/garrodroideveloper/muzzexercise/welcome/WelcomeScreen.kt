package com.garrodroideveloper.muzzexercise.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.garrodroideveloper.muzzexercise.R
import com.garrodroideveloper.muzzexercise.shared.ui.components.MuzzButton
import com.garrodroideveloper.muzzexercise.shared.ui.components.MuzzDivider

@Composable
fun WelcomeScreen(onClick: (String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        MuzzButton(name = "User", bottomValue = R.string.go_to_chat) {
            onClick("User")
        }
        MuzzDivider()
        MuzzButton(name = "Sarah", bottomValue = R.string.go_to_chat) {
            onClick("Sarah")
        }
    }
}
