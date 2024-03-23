package com.garrodroideveloper.muzzexercise.shared.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.garrodroideveloper.muzzexercise.R

@Composable
fun MuzzSendMessageBox(
    modifier: Modifier = Modifier,
    onMessageSent: (String) -> Unit,
) {
    var chatBoxValue by remember { mutableStateOf(TextFieldValue("")) }
    Row(modifier = modifier) {
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
                onMessageSent(chatBoxValue.text)
                chatBoxValue = TextFieldValue("")
            },
        ) {
            Icon(
                Icons.Filled.Send,
                stringResource(id = R.string.arrow_back),
            )
        }
    }
}

@Composable
fun MuzzMessageOtherItem(text: String) {
    Box(
        modifier =
            Modifier
                .clip(
                    RoundedCornerShape(
                        topStart = 48f,
                        topEnd = 48f,
                        bottomStart = 0f,
                        bottomEnd = 48f,
                    ),
                )
                .background(MaterialTheme.colorScheme.onSecondary)
                .padding(dimensionResource(id = R.dimen.single_margin)),
        contentAlignment = Alignment.CenterStart,
    ) {
        MuzzSmallText(value = text)
    }
}

@Composable
fun MuzzMessageMineItem(text: String) {
    Box(
        modifier =
            Modifier
                .clip(
                    RoundedCornerShape(
                        topStart = 48f,
                        topEnd = 48f,
                        bottomStart = 48f,
                        bottomEnd = 0f,
                    ),
                )
                .background(MaterialTheme.colorScheme.primary)
                .padding(dimensionResource(id = R.dimen.single_margin)),
        contentAlignment = Alignment.CenterStart,
    ) {
        MuzzSmallText(value = text)
    }
}

@Preview
@Composable
private fun MuzzSendMessageBoxPreview() {
    MuzzSendMessageBox(onMessageSent = {})
}

@Preview
@Composable
private fun MuzzMessageOtherItemPreview() {
    MuzzMessageOtherItem("Other item")
}

@Preview
@Composable
private fun MuzzMessageMineItemPreview() {
    MuzzMessageMineItem("Mine item")
}
