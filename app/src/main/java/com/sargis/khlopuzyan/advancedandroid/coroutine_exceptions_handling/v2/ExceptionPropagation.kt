package com.sargis.khlopuzyan.advancedandroid.coroutine_exceptions_handling.v2

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * IMPORTANT *****************************
 * CoroutineExceptionHandler is invoked only on uncaught exceptions — exceptions that were not handled in any other way.
 * In particular, all children coroutines (coroutines created in the context of another Job) delegate handling of
 * their exceptions to their parent coroutine, which also delegates to the parent, and so on until the root,
 * so the CoroutineExceptionHandler installed in their context is never used. In addition to that,
 * async builder always catches all exceptions and represents them in the resulting Deferred object,
 * so its CoroutineExceptionHandler has no effect either.
 * */
@OptIn(DelicateCoroutinesApi::class)
fun main(): kotlin.Unit = runBlocking {

    val job = GlobalScope.launch { // root coroutine with launch
        println("Throwing exception from launch")
        throw IndexOutOfBoundsException() // Will be printed to the console by Thread.defaultUncaughtExceptionHandler
    }
    job.join()

    println("Joined failed job")

    delay(10)
    val deferred = GlobalScope.async { // root coroutine with async
        println("Throwing exception from async")
        throw ArithmeticException() // Nothing is printed, relying on user to call await
    }

//    deferred.await()

    try {
        deferred.await()
        println("Unreached")
    } catch (e: ArithmeticException) {
        println("Caught ArithmeticException")
    }
}