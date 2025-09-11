package com.sargis.khlopuzyan.advancedandroid.effectHandlers_3.non_suspended_effect_handler

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun SideEffectMain() {
    var count by remember { mutableIntStateOf(0) }

    /**
     * Remembered ? Never run any non-composable code inside composable function, always use side-effect for that.
     * */
//    log("Count is $count")

    SideEffect {
        log("Count is $count")
    }

//    Button(onClick = { count++ }) {
//        Text(text = "Click here!")
//    }

    Column {
        Button(onClick = { count++ }) {

            // Use SideEffect to log the current value of count
            SideEffect {
                // Called on every recomposition
                log("Inner Count is $count")
            }

            // This recomposition doesn't trigger the outer side effect
            // every time button has been tapped
            Text("Increase Count $count")
        }
    }
}

/** With the code above if the button is clicked then the output will be like this:*/
//Outer Count is 0
//Inner Count is 0
//Inner Count is 1
//Inner Count is 2
//Inner Count is 3

private fun log(text: String) {
    Log.d("sideeffect", text)
}