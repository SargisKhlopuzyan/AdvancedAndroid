package com.sargis.khlopuzyan.advancedandroid.effectHandlers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.delay

/**
 * 1. LaunchedEffect:
 * A compose function that allows you to pass 1 or more keys and a code
 * that you want to execute every time our key changes.
 *
 * Uses-Cases:
 *
 * For showing Snackbar
 * For re-setting UiStates
 * For Navigation Events
 * 4. Starting Animations/Some one-time events
 * */

@Composable
fun LaunchedEffectComposable() {
    val text = remember {
        mutableStateOf("")
    }

    LaunchedEffect(key1 = text) {
        delay(100)
        println("LOG_TAG_ Printing $text")
    }
}
