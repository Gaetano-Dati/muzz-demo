package com.garrodroideveloper.muzzexercise.shared.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun MuzzButton(
    name: String,
    @StringRes bottomValue: Int,
    onClick: () -> Unit,
) {
    OutlinedButton(
        onClick = { onClick() },
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground),
        shape = RoundedCornerShape(50), // = 50% percent
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            MuzzMediumText(value = name)
            MuzzSmallText(value = stringResource(id = bottomValue))
        }
    }
}
