package com.sargis.khlopuzyan.advancedandroid.yield

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.coroutines.yield

private fun main() = runBlocking {
    val singleThreadDispatcher = Dispatchers.Default.limitedParallelism(1)
    withContext(singleThreadDispatcher) {
        launch {
            repeat(5) {
                updateProgressBar(it, "A")
                yield()
            }
        }

        launch {
            repeat(5) {
                updateProgressBar(it, "B")
                yield()
            }
        }
        Unit
    }
}


private fun updateProgressBar(value: Int, marker: String) {
    println("LOG_TAG_marker: $marker, value: $value")
}
