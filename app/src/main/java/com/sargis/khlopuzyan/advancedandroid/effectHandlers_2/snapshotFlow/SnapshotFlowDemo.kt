package com.sargis.khlopuzyan.advancedandroid.effectHandlers_2.snapshotFlow

import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.mapNotNull

/**
 * 8. snapshotFlow:
 * It works exact opposite of collectAsState.
 * This compose function is used to convert a compose state into a flow that emits values whenever a compose state changes.
 * */
@Composable
fun SnapshotFlowDemo() {

    val listState = rememberLazyListState()


    LaunchedEffect(listState) {
        snapshotFlow { listState.firstVisibleItemIndex }
            .mapNotNull { index ->
                index > 0
            }
            .distinctUntilChanged()
            .filter {
                it == true
            }.collect {

            }
    }
}