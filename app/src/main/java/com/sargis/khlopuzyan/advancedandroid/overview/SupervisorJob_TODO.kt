package com.sargis.khlopuzyan.advancedandroid.overview

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking {

//    val context = SupervisorJob() +
    val context = Job() +
            Dispatchers.IO +
            CoroutineName("Any") +
            CoroutineExceptionHandler { context, throwable ->
                println("*** CoroutineExceptionHandler * MAIN * - throwable : $throwable")
            }

    val handler = CoroutineExceptionHandler { context, throwable ->
        println("*** CoroutineExceptionHandler * CHILD * - throwable : $throwable")
    }

    val scope = CoroutineScope(context)

    launch {
        launch {
            println("launch-1")
        }

        launch(context) {
//        scope.launch {

            launch {
                delay(50)
                println("launch-2-1")
            }

            launch {
                delay(100)
                println("launch-2-2")
            }

            launch {
                delay(600)
                println("launch-2-3")
            }

            delay(200)

            throw Exception("Exception-in-*launch-2")
        }

        launch {
            delay(1000)
            println("launch-3")
        }
    }.join()
}