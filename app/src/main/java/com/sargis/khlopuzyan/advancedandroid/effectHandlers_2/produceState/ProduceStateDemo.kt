package com.sargis.khlopuzyan.advancedandroid.effectHandlers_2.produceState

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.produceState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

// produceState is almost like flow,
// the main purpose is to produce state that changes over time (more compose way)
@Composable
fun ProduceStateDemo(countUpTo: Int): State<Int> {
    return produceState(initialValue = 0) {
        while (value < countUpTo) {
            delay(1000)
            value += 1
        }
    }
}

@Composable
fun FloDemo(countUpTo: Int): State<Int> {
    var value = 0
    return flow<Int> {
        while (value < countUpTo) {
            delay(1000)
            value += 1
        }
    }.collectAsState(0)
}