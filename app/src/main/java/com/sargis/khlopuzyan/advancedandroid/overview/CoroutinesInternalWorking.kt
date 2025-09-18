package com.sargis.khlopuzyan.advancedandroid.overview

import kotlinx.coroutines.delay
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

//TODO-URL : https://www.youtube.com/watch?v=pX8DhKpVUGk

private suspend fun main() {
    println("Before")
    //Time consuming operation
//    suspendCoroutine<Unit> { continuation ->
//        112
//        println("Inside suspendCoroutine")
//        continuation.resume(Unit)
//    }

    delay(100)
    println("After")
}