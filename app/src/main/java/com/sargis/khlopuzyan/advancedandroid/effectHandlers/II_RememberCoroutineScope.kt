package com.sargis.khlopuzyan.advancedandroid.effectHandlers

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * 2. rememberCoroutineScope:
 * A composable function that gives reference to a composition-aware coroutine scope.
 *
 * Uses-cases:
 *
 * onClicks
 * Animations
 * Callbacks
 * */
@Composable
fun RememberCoroutineScopeComposable() {
    val scope = rememberCoroutineScope()
    Button(
        onClick = {
            scope.launch {
                delay(300)
            }
        }
    ) {
        Text(text = "")
    }
}