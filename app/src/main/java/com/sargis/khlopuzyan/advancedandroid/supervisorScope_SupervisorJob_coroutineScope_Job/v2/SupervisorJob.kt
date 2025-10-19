package com.sargis.khlopuzyan.advancedandroid.supervisorScope_SupervisorJob_coroutineScope_Job.v2

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() {
    runBlocking {
        launch {
            delay(100)
            println("launch - 1")
        }

        val ceh = CoroutineExceptionHandler { _, e ->
            println("launch - 2 - launch - 2 - ********** CoroutineExceptionHandler: $e")
        }

//        launch(SupervisorJob() + ceh) {
        launch(SupervisorJob()) {
            launch {
                delay(150)
                println("launch - 2 - launch - 1")
            }

            launch(ceh) {
//            launch {
                delay(250)
                println("launch - 2 - launch - 2")
                throw IllegalArgumentException("********** launch - 2 - launch - 2")
            }

            launch {
                delay(350)
                println("launch - 2 - launch - 3")
            }

            delay(200)
            println("launch - 2")
//            throw IllegalArgumentException("********** launch - 2")
        }

        launch {
            delay(300)
            println("launch - 3")
        }

        launch {
            delay(400)
            println("launch - 4")
        }
    }
}