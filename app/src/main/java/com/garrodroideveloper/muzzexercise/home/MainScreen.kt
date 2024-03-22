package com.garrodroideveloper.muzzexercise.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.garrodroideveloper.muzzexercise.R
import com.garrodroideveloper.muzzexercise.shared.ui.components.MuzzMediumText

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        MuzzMediumText(value = stringResource(id = R.string.main))
    }
}
