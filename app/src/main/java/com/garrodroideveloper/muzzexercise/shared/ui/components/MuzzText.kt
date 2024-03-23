package com.garrodroideveloper.muzzexercise.shared.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MuzzSmallText(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    value: String,
) {
    Text(
        modifier = modifier,
        text = value,
        style = MaterialTheme.typography.bodySmall,
        color = color,
    )
}

@Composable
fun MuzzMediumText(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    value: String,
) {
    Text(
        modifier = modifier,
        text = value,
        style = MaterialTheme.typography.bodyMedium,
        color = color,
    )
}

@Composable
fun MuzzTitleText(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    value: String,
) {
    Text(
        modifier = modifier,
        text = value,
        style = MaterialTheme.typography.titleLarge,
        color = color,
    )
}
