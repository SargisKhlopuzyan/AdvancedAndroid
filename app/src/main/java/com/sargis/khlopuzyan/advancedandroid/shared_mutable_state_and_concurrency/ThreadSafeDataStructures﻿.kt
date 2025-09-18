package com.sargis.khlopuzyan.advancedandroid.shared_mutable_state_and_concurrency

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis

private val counter = AtomicInteger()

private fun main() = runBlocking {
    withContext(Dispatchers.Default) {
        massiveRun {
            counter.incrementAndGet()
        }
    }

    println("LOG_TAG counter: $counter")
}

private suspend fun massiveRun(action: suspend () -> Unit) {

    val n = 100  // number of coroutines to launch
    val k = 1000 // times an action is repeated by each coroutine

    val time = measureTimeMillis {
        coroutineScope { // scope for coroutines
            repeat(n) {
                launch {
                    repeat(k) {
                        action()
                    }
                }
            }
        }
    }
    println("LOG_TAG Completed ${n * k} actions in $time ms")
}