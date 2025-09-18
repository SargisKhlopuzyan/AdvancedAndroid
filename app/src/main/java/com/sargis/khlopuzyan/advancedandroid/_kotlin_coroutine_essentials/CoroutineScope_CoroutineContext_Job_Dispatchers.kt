package com.sargis.khlopuzyan.advancedandroid._kotlin_coroutine_essentials

import kotlinx.coroutines.CompletableJob
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() {
    runBlocking {
        println("Start")

//        val context = Job() +
        val context = SupervisorJob() +
                Dispatchers.Default +
                CoroutineName("Test") +
                CoroutineExceptionHandler { context, throwable -> }

        val supervisorContext = SupervisorJob() +
                Dispatchers.Default +
                CoroutineName("Test") +
                CoroutineExceptionHandler { context, throwable -> }

//        val completableContext = CompletableJob() +
//                Dispatchers.Default +
//                CoroutineName("Test") +
//                CoroutineExceptionHandler { context, throwable -> }

        val scope = CoroutineScope(context)

        scope.launch {
            launch {

            }
        }

        scope.async { }

        val job = scope.async {
            delay(1000)
            println("Coroutine completed")
            1
        }

        scope.cancel()

        val result = job.await()
        println("result: $result")
    }

    println("runBlocking ends")
}