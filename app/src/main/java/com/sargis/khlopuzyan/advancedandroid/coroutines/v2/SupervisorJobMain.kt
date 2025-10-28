package com.sargis.khlopuzyan.advancedandroid.coroutines.v2

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * When you pass SupervisorJob() to a CoroutineScope, that scope becomes a supervisor for its children.
 * This means that each child launched in that scope is isolated from the failure of its siblings.
 *
 * However, a critical thing to note is that SupervisorJob does not automatically handle exceptions inside nested child coroutines.
 * You need to manually handle exceptions inside each coroutine to prevent failure propagation.
 * **/
fun main() = runBlocking {
    val handler = CoroutineExceptionHandler { _, t ->
        println("t: $t")
    }


//    val customScope = CoroutineScope(handler)
//    val customScope = CoroutineScope(SupervisorJob() + handler)
    val customScope = CoroutineScope(SupervisorJob())
    launch {
        launch {
            println("launch-1")
        }

        val handler2 = CoroutineExceptionHandler { _, t ->
            println("t2: $t")
        }

        delay(100)

//        coroutineScope {
        customScope.launch {
//        customScope.launch(handler2) {
            delay(200)
            println("launch-2")

            launch {
                delay(100)
                println("launch-2-1")
            }

            launch {
                delay(300)
                println("launch-2-2")
                throw IllegalArgumentException("LAUNCH-2-2")
            }

            launch {
                delay(500)
                println("launch-2-3")
            }
        }

        launch {
            delay(600)
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