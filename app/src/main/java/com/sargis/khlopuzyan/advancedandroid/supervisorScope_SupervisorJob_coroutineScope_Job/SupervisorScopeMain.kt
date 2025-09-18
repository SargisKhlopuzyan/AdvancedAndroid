package com.sargis.khlopuzyan.advancedandroid.supervisorScope_SupervisorJob_coroutineScope_Job

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

private fun main() = runBlocking {
    supervisorScope {
        launch { println("Data 1: ${getData1()}") }
        launch { println("Data 2: ${getData2()}") } // Fails
        launch { println("Data 3: ${getData3()}") }
    }.join()

    launch {
        println("launch")
    }

    Unit
}