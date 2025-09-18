package com.sargis.khlopuzyan.advancedandroid.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

private fun main() = runBlocking {
    suspendCoroutineFunction()

    coroutineScope {
        val result = async {
            delay(100)
            println("OK")
        }

    }

    //
}

private suspend fun suspendCoroutineFunction() {
    println("LOG_TAG_suspendCoroutineFunction:1")
    val result = suspendCoroutine { continuation ->
        thread {
            Thread.sleep(1000)
            continuation.resume("OK")
        }
    }
    println("suspendCoroutineFunction:2:$result")
}