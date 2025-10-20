package com.sargis.khlopuzyan.advancedandroid.effectHandlers_4

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay

@Composable
fun RememberUpdatedStateDemo(
    onEvent: () -> Unit
) {
    val onUpdatedEvent by rememberUpdatedState(newValue = onEvent)

    LaunchedEffect(Unit) {
        delay(3000)
        onUpdatedEvent()
    }
}