package com.sargis.khlopuzyan.advancedandroid.supervisorScope_SupervisorJob_coroutineScope_Job

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//TODO-URL : https://medium.com/@adityamishra2217/understanding-supervisorscope-supervisorjob-coroutinescope-and-job-in-kotlin-a-deep-dive-into-bcd0b80f8c6f

private fun main() = runBlocking {
    coroutineScope {
        launch {
            println("Data 1: ${getData1()}")
        }
        launch {
            println("Data 2: ${getData2()}")
        }
        launch {
            println("Data 3: ${getData3()}")
        }
    }.join()
}

suspend fun getData1() = delay(1000).run { "data 1" }
suspend fun getData2(): Nothing = delay(300).run {
    throw RuntimeException("Error in Data 2")
}
suspend fun getData3() = delay(800).run { "data 3" }