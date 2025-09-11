package com.sargis.khlopuzyan.advancedandroid.effectHandlers_3.suspended_effect_handler

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun RememberCoroutineScopeMain() {

    val coroutineScope = rememberCoroutineScope()

    val data = remember {
        mutableStateOf("")
    }

    Button(onClick = {
        coroutineScope.launch {
            // Simulate network call
            delay(2000)
            data.value = "Data loaded"
        }
    }) {
        Text("Load data")
    }

    Text(text = data.value)
}