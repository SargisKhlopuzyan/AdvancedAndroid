package com.sargis.khlopuzyan.advancedandroid.effectHandlers_4

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun RememberCoroutineScopeDemo() {
    val scope = rememberCoroutineScope()
//    scope.launch {  } // Error
    Button(
        onClick = {
            scope.launch {
                delay(300)
            }
        }
    ) {
        Text(text = "Remember Coroutine Scope Demo")
    }
}