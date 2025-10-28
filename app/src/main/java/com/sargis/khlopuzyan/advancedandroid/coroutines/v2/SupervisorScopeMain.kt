package com.sargis.khlopuzyan.advancedandroid.coroutines.v2

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

/**
 * Unlike a SupervisorJob, which only supervises its direct children in a CoroutineScope, supervisorScope {} is
 * a special coroutine builder that ensures full failure isolation for all coroutines within the scope.
 * It works like a SupervisorJob, but the entire scope becomes the supervisor.
 *
 * The key distinction between supervisorScope and a CoroutineScope with SupervisorJob is that within a supervisorScope,
 * failures are isolated without the need for additional exception handling at the coroutine level.
 * Any child coroutine’s failure does not propagate to its siblings or the parent scope.
 * */
fun main() = runBlocking {
    val handler = CoroutineExceptionHandler { _, t ->
        println("t: $t")
    }

//    val customScope = CoroutineScope(handler)
//    val customScope = CoroutineScope(SupervisorJob() + handler)
    val customScope = CoroutineScope(SupervisorJob())
//    customScope.launch(handler) {

    launch {
        launch {
            println("launch-1")
        }

        val handler2 = CoroutineExceptionHandler { _, t ->
            println("t2: $t")
        }

//        launch(handler2) { // TODO - WORKING with supervisorScope, NOT WORKING with customScope
        supervisorScope {
            delay(200)
            println("launch-2")

            launch {
                delay(100)
                println("launch-2-1")
            }

//            launch(handler2) {
            launch {
                delay(200)
                println("launch-2-2")
                throw IllegalArgumentException("LAUNCH-2-2")
            }

            launch {
                delay(500)
                println("launch-2-3")
            }
        }

        launch {
            delay(300)
            println("launch-3")
        }
    }

    launch {
        delay(50)
        println("launch-4")
    }

    launch {
        delay(800)
        println("launch-5")
    }

    delay(2000)
}