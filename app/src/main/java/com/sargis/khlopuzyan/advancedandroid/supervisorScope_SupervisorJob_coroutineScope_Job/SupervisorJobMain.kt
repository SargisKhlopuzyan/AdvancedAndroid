package com.sargis.khlopuzyan.advancedandroid.supervisorScope_SupervisorJob_coroutineScope_Job

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val customCoroutineScope = CoroutineScope(SupervisorJob())
    launch {
        customCoroutineScope.launch {
            launch { println("Data 1: ${getData1()}") }
            launch { println("Data 2: ${getData2()}") } // Fails
            launch { println("Data 3: ${getData3()}") }
        }.join()

        launch {
            delay(100)
            println("launch")
        }
    }
    Unit
}