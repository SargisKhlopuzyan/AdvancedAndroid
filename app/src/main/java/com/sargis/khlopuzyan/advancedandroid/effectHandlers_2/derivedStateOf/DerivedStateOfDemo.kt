package com.sargis.khlopuzyan.advancedandroid.effectHandlers_2.derivedStateOf

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

/**
 * 7. derivedStateOf:
 * This compose function is used to optimize the performance by helping in reducing the recompositions.
 * We can use it to convert one or multiple state objects into another state.
 * */
@Composable
fun DerivedStateOfDemo() {

    var counter by remember {
        mutableIntStateOf(0)
    }

    val counterText by remember{
        derivedStateOf {
            if (counter > 10) {
                "The high counter value is $counter"
            } else {
                "Low counter"
            }
        }
    }

    Button(
        onClick = {
            counter++
        }
    ) {
        Text(text = counterText)
    }
}