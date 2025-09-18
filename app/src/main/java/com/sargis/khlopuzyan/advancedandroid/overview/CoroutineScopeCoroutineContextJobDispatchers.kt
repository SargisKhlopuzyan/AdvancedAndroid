package com.sargis.khlopuzyan.advancedandroid.overview

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//TODO-URL : https://www.youtube.com/watch?v=zfnzlVidQJo&ab_channel=SagarMalhotra
/**
 * Job, SupervisorJob, CompletableJob
 * */
/**
 * Supervisor
 * */
private fun main() = runBlocking {
    println("start: ${Thread.currentThread().name}")

    val context = SupervisorJob() +
            Dispatchers.IO +
            CoroutineName("Any") +
            CoroutineExceptionHandler { context, throwable ->
                println("~~~ CoroutineExceptionHandler * main * (SupervisorJob) ~~~")
            }

    val contextChild = SupervisorJob() +
            Dispatchers.IO +
            CoroutineName("Any") +
            CoroutineExceptionHandler { context, throwable ->
                println("~~~ CoroutineExceptionHandler * child * (SupervisorJob) ~~~")
            }

    val scope = CoroutineScope(context)
    val scopeChild = CoroutineScope(context)

    scope.launch {

        println("scope.launch-1: ${Thread.currentThread().name}")

//        launch {
        launch(contextChild) {
            delay(200)
            throw Exception("**Exception**")
        }

//        launch {
        launch(contextChild) {
            delay(100)
            println("scope.launch-2: ${Thread.currentThread().name}")
        }

//        launch {
        launch(contextChild) {
            delay(300)
            println("scope.launch-3: ${Thread.currentThread().name}")
        }

        delay(400)

        println("scope.launch-4: ${Thread.currentThread().name}")

        delay(300)

        println("scope.launch-5: ${Thread.currentThread().name}")

    }.join()

    println("end: ${Thread.currentThread().name}")
}

/**
 * RESULT:
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * start: main
 * scope.launch-1: DefaultDispatcher-worker-1
 * scope.launch-2: DefaultDispatcher-worker-4
 * ~~~ CoroutineExceptionHandler * main * ~~~
 * end: main
 * */
private fun main3() = runBlocking {
    println("start: ${Thread.currentThread().name}")
    val globalScope = GlobalScope

    val context = Job() +
            Dispatchers.IO +
            CoroutineName("Any") +
            CoroutineExceptionHandler { context, throwable ->
                println("~~~ CoroutineExceptionHandler * main * ~~~")
            }

    val contextChild = Job() +
            Dispatchers.IO +
            CoroutineName("Any") +
            CoroutineExceptionHandler { context, throwable ->
                println("~~~ CoroutineExceptionHandler * child * ~~~")
            }

    val scope = CoroutineScope(context)

    scope.launch {

        println("scope.launch-1: ${Thread.currentThread().name}")

//        launch(contextChild) {
        launch {
            delay(200)
            throw Exception("**Exception**")
        }

        launch {
            delay(100)
            println("scope.launch-2: ${Thread.currentThread().name}")
        }

        launch {
            delay(300)
            println("scope.launch-3: ${Thread.currentThread().name}")
        }

        delay(400)

        println("scope.launch-4: ${Thread.currentThread().name}")

        delay(300)

        println("scope.launch-5: ${Thread.currentThread().name}")

    }.join()

    println("end: ${Thread.currentThread().name}")
}

private fun main2() {
    runBlocking {
        println("start ThreadName: ${Thread.currentThread().name}")

//        val job = GlobalScope.launch {
//            println("launch-1 ${Thread.currentThread().name}")
//            delay(1000)
//            println("launch-2 ${Thread.currentThread().name}")
//        }
//        job.join()

        val deferred = GlobalScope.async {
            println("deferred-1 ThreadName: ${Thread.currentThread().name}")
            delay(1000)
            println("deferred-2 ThreadName: ${Thread.currentThread().name}")
            1
        }

//    deferred.join()
        val deferredResult = deferred.await()

        println("deferredResult : ${deferredResult}, ThreadName: ${Thread.currentThread().name}")
        println("end ThreadName: ${Thread.currentThread().name}")
    }

    // Error !!!
//    val job = GlobalScope.launch {
//
//    }
//    job.join()
//
//    val deffered = GlobalScope.async {
//
//    }
//    deffered.await()
}