package com.sargis.khlopuzyan.advancedandroid.effectHandlers_4

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

/**
 * It works exact opposite of collectAsState.
 * This compose function is used to convert a compose state into a flow that emits values whenever a compose state changes.
 * */
@Composable
fun SnapshotFlowDemo() {
//    val listState = rememberLazyListState()
    var state = generateFlow().collectAsState(0)

    LaunchedEffect(state) {
        snapshotFlow {
            state.value
        }.map { s ->
            s * s
        }.distinctUntilChanged().filter {
            it > 50
        }.collect {
            it
        }
    }
}

private fun generateFlow() = flow<Int> {
    (0 until 100).forEach {
        emit(it)
    }
}