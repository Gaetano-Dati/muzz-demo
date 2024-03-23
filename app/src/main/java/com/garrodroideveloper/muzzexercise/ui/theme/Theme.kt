package com.garrodroideveloper.muzzexercise.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme =
    lightColorScheme(
        primary = Purple,
        onPrimary = White,
        secondary = LightGrey,
        onSecondary = DarkGrey,
        onBackground = Black,
    )

@Composable
fun MuzzExerciseTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = MaterialTheme.typography,
        content = content,
    )
}
