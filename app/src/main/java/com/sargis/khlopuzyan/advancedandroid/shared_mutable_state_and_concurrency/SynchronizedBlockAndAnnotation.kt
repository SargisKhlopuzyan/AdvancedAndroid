package com.sargis.khlopuzyan.advancedandroid.shared_mutable_state_and_concurrency

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.system.measureTimeMillis

//TODO-URL: https://www.google.com/search?q=synchronization+in+kotln&oq=synchronization+in+kotln&gs_lcrp=EgZjaHJvbWUyBggAEEUYOTIJCAEQABgNGIAEMgoIAhAAGAUYDRgeMg0IAxAAGIYDGIAEGIoFMg0IBBAAGIYDGIAEGIoFMgoIBRAAGKIEGIkFMgoIBhAAGIAEGKIE0gEJMTU3NTdqMGo3qAIAsAIA&sourceid=chrome&ie=UTF-8

private var counter = 0

fun main() = runBlocking {
    withContext(Dispatchers.Default) {
        massiveRun {
            // Both are correct
            synchronizedIncrementCounter()
            // or
//            synchronized(this) {
//                counter++
//            }
        }
    }
    println("Counter = $counter")
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

@Synchronized
private fun synchronizedIncrementCounter() {
    counter++
}