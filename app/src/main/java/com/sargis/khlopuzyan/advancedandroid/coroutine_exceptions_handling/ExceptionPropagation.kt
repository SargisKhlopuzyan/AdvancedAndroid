package com.sargis.khlopuzyan.advancedandroid.coroutine_exceptions_handling

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@OptIn(DelicateCoroutinesApi::class)
fun main() = runBlocking {

    val job = GlobalScope.launch { // root coroutine with launch
        println("LOG_TAG Throwing exception from launch")
        throw IndexOutOfBoundsException() // Will be printed to the console by Thread.defaultUncaughtExceptionHandler
    }
    job.join()

    println("LOG_TAG Joined failed job")

    val deferred = GlobalScope.async { // root coroutine with async
        println("LOG_TAG Throwing exception from async")
        throw ArithmeticException() // Nothing is printed, relying on user to call await
    }

    try {
        deferred.await()
        println("LOG_TAG Unreached")
    } catch (e: ArithmeticException) {
        println("LOG_TAG Caught ArithmeticException")
    }
}