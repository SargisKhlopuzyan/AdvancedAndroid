package com.sargis.khlopuzyan.advancedandroid.effectHandlers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.getValue
import kotlinx.coroutines.delay

/**
 * 3. rememberUpdatedState:
 * remember a mutableStateOf and update its value to newValue on each recomposition of the rememberUpdatedState call.
 *
 * We can use the rememberUpdatedState side-effect to store the latest state of any value,
 * and only the updated value will be passed on to further uses.
 * */
@Composable
fun RememberUpdatedStateComposable(
    onEvent: () -> Unit
) {
    val onUpdatedEvent by rememberUpdatedState(newValue = onEvent)

    LaunchedEffect(Unit) {
        delay(3000)
        onUpdatedEvent()
    }
}