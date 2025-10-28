package com.sargis.khlopuzyan.advancedandroid.coroutines.coroutines_internal_working

import kotlinx.coroutines.delay

suspend private fun main() {
    println("Before")
    delay(1000)
//    suspendCancellableCoroutine { continuation ->
//        continuation.resume(Unit)
//    }
    println("After")
}