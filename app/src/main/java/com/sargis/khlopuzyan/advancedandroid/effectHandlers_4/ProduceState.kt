package com.sargis.khlopuzyan.advancedandroid.effectHandlers_4

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import kotlinx.coroutines.delay

/**
 * It is used to convert a non-compose state (flow, etc) into a composed state
 * */
@Composable
fun ProduceStateDemo() {
}

@Composable
fun loadNetworkImage(

): State<Int> {
    return produceState<Int>(initialValue = 0) {
        (0 until 10).forEach { v: Int ->
            delay(v * 100L)
            value = v
        }
    }
}