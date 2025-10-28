package com.sargis.khlopuzyan.advancedandroid.coroutines.supervisorScope_SupervisorJob_coroutineScope_Job.v2

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

private suspend fun main() {
    runBlocking {
        supervisorScope {
            launch {
                delay(100)
                println("launch - 1")
            }

            launch {

                launch {
                    delay(100)
                    println("launch - 2 - launch - 1")
                }

                launch {
                    delay(300)
                    println("launch - 2 - launch - 2")
                }

                delay(200)
                println("launch - 2")
                throw IllegalArgumentException()
            }

            launch {
                delay(300)
                println("launch - 3")
            }
        }
    }
}