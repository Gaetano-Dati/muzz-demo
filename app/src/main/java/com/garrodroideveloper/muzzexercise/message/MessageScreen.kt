package com.garrodroideveloper.muzzexercise.message

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import com.garrodroideveloper.muzzexercise.R
import com.garrodroideveloper.muzzexercise.shared.ui.components.MuzzMessageMineItem
import com.garrodroideveloper.muzzexercise.shared.ui.components.MuzzMessageOtherItem
import com.garrodroideveloper.muzzexercise.shared.ui.components.MuzzSendMessageBox
import com.garrodroideveloper.muzzexercise.shared.ui.components.MuzzTimestamp
import timber.log.Timber

@Composable
fun MessageScreen() {
    val messageViewModel: MessageScreenViewModel = hiltViewModel()

    val messagesList by messageViewModel.messages.collectAsState(initial = emptyList())
    val userIds by messageViewModel.userIds.collectAsState(Pair("", ""))
    val myId = userIds.first

    val listState = rememberLazyListState()

    LaunchedEffect(messagesList.size) {
        if (messagesList.isNotEmpty()) {
            listState.scrollToItem(messagesList.lastIndex)
        }
    }

    ConstraintLayout(
        modifier =
            Modifier
                .imePadding() // This makes the keyboard not push out the text
                .fillMaxSize(),
    ) {
        val (messages, chatBox) = createRefs()

        if (messagesList.isEmpty()) {
            MuzzTimestamp(timestamp = System.currentTimeMillis())
        }

        LazyColumn(
            state = listState,
            modifier =
                Modifier
                    .padding(top = dimensionResource(id = R.dimen.single_margin))
                    .fillMaxWidth()
                    .constrainAs(messages) {
                        top.linkTo(parent.top)
                        bottom.linkTo(chatBox.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        height = Dimension.fillToConstraints
                    },
        ) {
            val anHourOldMessage =
                messagesList.lastOrNull {
                    (System.currentTimeMillis() - it.createdAt) > 3600000
                }
            if (messagesList.isNotEmpty()) {
                items(messagesList) { item ->
                    if (item == anHourOldMessage) {
                        MuzzTimestamp(timestamp = item.createdAt)
                    }

                    if (item.senderId == myId) {
                        // My message
                        MuzzMessageMineItem(item)
                    } else {
                        // Other message
                        MuzzMessageOtherItem(item.message)
                    }
                }
            }
        }

        MuzzSendMessageBox(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .constrainAs(chatBox) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
            onMessageSent = { message ->
                Timber.d("Message sent -> $message")
                messageViewModel.addMessage(message, myId)
            },
        )
    }
}
