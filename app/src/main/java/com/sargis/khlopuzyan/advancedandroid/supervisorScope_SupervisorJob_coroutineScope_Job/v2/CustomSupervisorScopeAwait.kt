package com.sargis.khlopuzyan.advancedandroid.supervisorScope_SupervisorJob_coroutineScope_Job.v2

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

private suspend fun main() = runBlocking {

    val context: CoroutineContext =
//        Job() +
        SupervisorJob() +
                Dispatchers.IO +
                CoroutineName("Custom") +
                CoroutineExceptionHandler { _, e ->
                    println("CoroutineExceptionHandler -> throwable : $e")
                }

    val scope = CoroutineScope(context)

    println("main - start")

    val deferred1 = scope.async {

        println("supervisorScope - start")

        launch {
            delay(100)
            println("launch-1")
        }

//        launch(SupervisorJob()) {
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

    val deferred2 = scope.async {
        delay(500)
        println("scope **** 2")
    }

    launch {
        delay(400)
        println("launch-4")
    }

    delay(1000)
    println("main - end")
}