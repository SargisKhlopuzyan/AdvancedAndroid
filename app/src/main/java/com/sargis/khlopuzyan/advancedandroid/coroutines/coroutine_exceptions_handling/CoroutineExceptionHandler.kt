package com.sargis.khlopuzyan.advancedandroid.coroutines.coroutine_exceptions_handling

import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)
private fun main() = runBlocking {

    val handler = CoroutineExceptionHandler { _, exception ->
        println("CoroutineExceptionHandler got $exception")
    }

    val job = GlobalScope.launch(handler) { // root coroutine, running in GlobalScope
        throw AssertionError()
    }

    val deferred = GlobalScope.async(handler) { // also root, but async instead of launch
        println("deferred")
        throw ArithmeticException() // Nothing will be printed, relying on user to call deferred.await()
    }

//    deferred.await()

    joinAll(job, deferred)
}