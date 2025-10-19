package com.sargis.khlopuzyan.advancedandroid.supervisorScope_SupervisorJob_coroutineScope_Job.v2

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private suspend fun main() {
    println("main - start")
//    supervisorScope {
    coroutineScope {
        println("supervisorScope - start")

        launch {
            delay(100)
            println("launch-1")
        }

        launch {
            delay(200)
            println("launch-2")
            throw IllegalArgumentException("Exception * launch-2")
        }

        launch {
            delay(300)
            println("launch-3")
        }

        println("supervisorScope - end")
    }

    println("main - end")
}