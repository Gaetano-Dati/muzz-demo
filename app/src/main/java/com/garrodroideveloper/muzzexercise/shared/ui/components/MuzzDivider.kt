package com.garrodroideveloper.muzzexercise.shared.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.garrodroideveloper.muzzexercise.R

@Composable
fun MuzzDivider() {
    Divider(
        modifier = Modifier.height(dimensionResource(id = R.dimen.single_margin)),
        color = MaterialTheme.colorScheme.background,
    )
}
