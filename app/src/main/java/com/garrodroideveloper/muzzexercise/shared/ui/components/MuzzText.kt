package com.garrodroideveloper.muzzexercise.shared.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MuzzSmallText(
    modifier: Modifier = Modifier,
    value: String,
) {
    Text(
        modifier = modifier,
        text = value,
        style = MaterialTheme.typography.bodySmall,
    )
}

@Composable
fun MuzzMediumText(
    modifier: Modifier = Modifier,
    value: String,
) {
    Text(
        modifier = modifier,
        text = value,
        style = MaterialTheme.typography.bodyMedium,
    )
}
