package com.sargis.khlopuzyan.advancedandroid.effectHandlers_3.side_effect_states

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

@Composable
fun RememberUpdateStateMain() {
    // A surface container using the 'background' color from the theme
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        var dynamicData by remember {
            mutableStateOf("")
        }

        LaunchedEffect(Unit) {
            delay(3000L)
            dynamicData = "New Text"
        }

        MyComponent(title = dynamicData)
    }
}

@Composable
private fun MyComponent(title: String) {

    var data by remember {
        mutableStateOf("")
    }

    val updatedData by rememberUpdatedState(title)

    LaunchedEffect(Unit) {
        delay(5000L)
        data = updatedData
    }

    Text(text = data)
}