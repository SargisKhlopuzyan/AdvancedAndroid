package com.sargis.khlopuzyan.advancedandroid.effectHandlers_4

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


var notComposeState = "" //Outside compose

@Composable
fun SideEffectDemo() {

    SideEffect {
        println("print this in compose")
    }

    Column {

        var composeState by remember {
            mutableStateOf("")
        }

        val notComposeUpdatedValue = someCompose(composeState, notComposeState)

        Text(text = "ComposeStateValue = $composeState")
        Button(onClick = {
            composeState += "*"
        }) {
            Text(text = "Update ComposeState")
        }

        Text(text = "NotComposeState = $notComposeUpdatedValue")
        Button(onClick = {
            notComposeState += "*"
        }) {
            Text(text = "Update NotComposeState")
        }
    }
}

private fun someCompose(composeState: String, notComposeState: String) {

}