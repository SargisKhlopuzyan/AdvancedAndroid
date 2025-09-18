package com.sargis.khlopuzyan.advancedandroid.stateIn_shareIn

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking {
    val stateFlow = returnsFlow().stateIn(this, SharingStarted.Lazily, 0)
    val sharedFlow = returnsFlow().shareIn(this, SharingStarted.Lazily)
}

private fun returnsFlow(): Flow<Int> = flow {
    (0..10).forEach { index ->
        emit(index)
    }
}