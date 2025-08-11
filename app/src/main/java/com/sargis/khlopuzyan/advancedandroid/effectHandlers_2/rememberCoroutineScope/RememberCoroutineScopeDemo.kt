package com.sargis.khlopuzyan.advancedandroid.effectHandlers_2.rememberCoroutineScope

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun RememberCoroutineScopeDemo() {
    val scope = rememberCoroutineScope()
    // scope.launch {} // ERROR - Calls to launch should happen inside a LaunchedEffect and not composition
    Button(
        onClick = {
            scope.launch {
                delay(1000)
                println("Hello World!")
            }
        }
    ) {

    }
}