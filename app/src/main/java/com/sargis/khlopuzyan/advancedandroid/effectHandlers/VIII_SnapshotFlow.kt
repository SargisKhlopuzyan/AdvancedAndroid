package com.sargis.khlopuzyan.advancedandroid.effectHandlers

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map

/**
 * 8. snapshotFlow:
 * It works exact opposite of collectAsState.
 * This compose function is used to convert a compose state into a flow that emits values whenever a compose state changes.
 * */
@Composable
fun SnapshotFlowComposable() {
    val listState = rememberLazyListState()

    LazyColumn(state = listState) {
        // ...
    }

    LaunchedEffect(listState) {
        snapshotFlow { listState.firstVisibleItemIndex }
            .map { index -> index > 0 }
            .distinctUntilChanged()
            .filter { it == true }
            .collect {
//                MyAnalyticsService.sendScrolledPastFirstItemEvent()
            }
    }
}