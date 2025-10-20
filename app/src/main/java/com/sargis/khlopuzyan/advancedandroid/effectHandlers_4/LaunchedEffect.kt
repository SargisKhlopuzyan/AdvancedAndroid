package com.sargis.khlopuzyan.advancedandroid.effectHandlers_4

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.delay

/**
 * Uses-Cases:
 *
 * For showing Snackbar
 * For re-setting UiStates
 * For Navigation Events
 * 4. Starting Animations/Some one-time events
 * */
@Composable
fun LaunchedEffectDemo() {
    var text = remember {
        mutableStateOf("")
    }
    LaunchedEffect(key1 = true) {
        delay(100) //Supports suspend function
        print("Printing $text") //Everytime text changes
    }
}