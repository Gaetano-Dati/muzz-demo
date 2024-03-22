package com.garrodroideveloper.muzzexercise.shared.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.garrodroideveloper.muzzexercise.R

@Composable
fun MuzzMessage() {
    var chatBoxValue by remember { mutableStateOf(TextFieldValue("")) }
    Row {
        TextField(
            value = chatBoxValue,
            onValueChange = { newText ->
                chatBoxValue = newText
            },
            placeholder = {
                MuzzMediumText(value = stringResource(id = R.string.type_something))
            },
        )
        IconButton(
            enabled = chatBoxValue.text.isNotEmpty(),
            onClick = {
                // TODO: send the message
            },
        ) {
            Icon(
                Icons.Filled.Send,
                stringResource(id = R.string.arrow_back),
            )
        }
    }
}

@Preview
@Composable
private fun MuzzMessagePreview() {
    MuzzMessage()
}
