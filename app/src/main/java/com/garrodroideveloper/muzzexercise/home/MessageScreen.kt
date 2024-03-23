package com.garrodroideveloper.muzzexercise.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import com.garrodroideveloper.muzzexercise.shared.ui.components.MuzzMessageOtherItem
import com.garrodroideveloper.muzzexercise.shared.ui.components.MuzzSendMessageBox
import timber.log.Timber

@Composable
fun MessageScreen() {
    val messageViewModel: MessageScreenViewModel = hiltViewModel()
    val messagesList by messageViewModel.messages.collectAsState()
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (messages, chatBox) = createRefs()

        LazyColumn(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .constrainAs(messages) {
                        top.linkTo(parent.top)
                        bottom.linkTo(chatBox.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        height = Dimension.fillToConstraints
                    },
        ) {
            items(messagesList) { item ->
                MuzzMessageOtherItem(item.message)
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
            },
        )
    }
}
