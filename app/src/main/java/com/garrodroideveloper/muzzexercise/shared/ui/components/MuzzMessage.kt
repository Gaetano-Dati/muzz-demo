package com.garrodroideveloper.muzzexercise.shared.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.garrodroideveloper.muzzexercise.R
import com.garrodroideveloper.muzzexercise.storage.entities.Message

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MuzzSendMessageBox(
    onMessageSent: (String) -> Unit,
    modifier: Modifier,
) {
    var chatBoxValue by remember { mutableStateOf(TextFieldValue("")) }
    Surface(
        modifier = modifier,
        shadowElevation = 5.dp,
    ) {
        Row(modifier = Modifier.padding(dimensionResource(id = R.dimen.single_margin))) {
            TextField(
                colors =
                    TextFieldDefaults.colors(
                        disabledTextColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                    ),
                value = chatBoxValue,
                onValueChange = { newText ->
                    chatBoxValue = newText
                },
                modifier =
                    Modifier
                        .weight(1f)
                        .padding(4.dp),
                shape = RoundedCornerShape(24.dp),
            )
            IconButton(
                enabled = chatBoxValue.text.isNotEmpty(),
                onClick = {
                    val msg = chatBoxValue.text
                    if (msg.isBlank()) return@IconButton
                    onMessageSent(chatBoxValue.text)
                    chatBoxValue = TextFieldValue("")
                },
                modifier =
                    Modifier
                        .clip(CircleShape)
                        .background(color = MaterialTheme.colorScheme.primary)
                        .align(Alignment.CenterVertically),
            ) {
                Icon(
                    imageVector = Icons.Filled.Send,
                    contentDescription = "Send",
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                    tint = Color.White,
                )
            }
        }
    }
}

@Composable
fun MuzzMessageOtherItem(text: String) {
    Column(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(4.dp),
    ) {
        Box(
            modifier =
                Modifier
                    .align(Alignment.Start)
                    .clip(
                        RoundedCornerShape(
                            topStart = 48f,
                            topEnd = 48f,
                            bottomStart = 0f,
                            bottomEnd = 48f,
                        ),
                    )
                    .background(MaterialTheme.colorScheme.secondary)
                    .padding(dimensionResource(id = R.dimen.single_margin)),
            contentAlignment = Alignment.CenterStart,
        ) {
            MuzzMediumText(value = text, color = MaterialTheme.colorScheme.onBackground)
        }
    }
}

@Composable
fun MuzzMessageMineItem(message: Message) {
    Column(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(4.dp),
    ) {
        Box(
            modifier =
                Modifier
                    .align(Alignment.End)
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
        ) {
            Column(horizontalAlignment = Alignment.End) {
                MuzzMediumText(value = message.message, color = MaterialTheme.colorScheme.onPrimary)
                Image(
                    modifier = Modifier.width(15.dp).height(15.dp),
                    painter = painterResource(id = R.drawable.ic_double_check),
                    contentDescription = stringResource(id = R.string.arrow_back),
                    colorFilter =
                        ColorFilter.tint(
                            if (message.hasBeenSeen) {
                                Color.Cyan
                            } else {
                                Color.Yellow
                            },
                        ),
                )
            }
        }
    }
}

@Preview
@Composable
private fun MuzzSendMessageBoxPreview() {
    MuzzSendMessageBox(onMessageSent = {}, modifier = Modifier)
}

@Preview
@Composable
private fun MuzzMessageOtherItemPreview() {
    MuzzMessageOtherItem("Other item")
}

@Preview
@Composable
private fun MuzzMessageMineItemPreview() {
    MuzzMessageMineItem(
        Message(
            createdAt = 0,
            hasBeenSeen = false,
            message = "Mine item",
            senderId = "",
        ),
    )
}
