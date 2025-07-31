package com.sargis.khlopuzyan.advancedandroid.effectHandlers

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

/**
 * 7. derivedStateOf:
 * This compose function is used to optimize the performance by helping in reducing the recompositions.
 * We can use it to convert one or multiple state objects into another state.
 * */
@Composable
fun DerivedStateOfComposable() {
    var counter by remember {
        mutableIntStateOf(0)
    }

    val string by remember {
        derivedStateOf {
            if (counter > 10) {
                "The high counter values is $counter"
            } else {
                "Low counter"
            }
        }
    }
    Text(text = string)
    Button(onClick = { counter++ }) {
        Text(text = "Add")
    }
}