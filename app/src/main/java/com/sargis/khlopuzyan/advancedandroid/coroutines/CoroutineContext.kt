package com.sargis.khlopuzyan.advancedandroid.coroutines

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

val closeableCoroutineDispatcher = newSingleThreadContext("MyThread")

val handler = CoroutineExceptionHandler { coroutineContext, throwable ->
    println("LOG_TAG_CoroutineExceptionHandler got $throwable")
}

val customCoroutineContext = CoroutineName("CustomCoroutineContext") + Job() + Dispatchers.Unconfined + handler

fun main() = runBlocking {
    println("LOG_TAG_main_1 thread: ${Thread.currentThread().name}")
    val job = this.coroutineContext[Job]
//    withContext(Dispatchers.IO) {
//    withContext(closeableCoroutineDispatcher) {
//    withContext(customCoroutineContext) {
    println("LOG_TAG job: $job")
//    launch(GlobalScope.coroutineContext) {
    launch(customCoroutineContext) {
        val job = this.coroutineContext[Job]
        println("LOG_TAG_launch job: $job")
        doBackgroundWork()
    }
//    delay(2000)
    println("LOG_TAG_main_2 thread: ${Thread.currentThread().name}")
}


private suspend fun doBackgroundWork(): String {
    println("LOG_TAG_doBackgroundWork_1 thread: ${Thread.currentThread().name}")
    delay(1000)
    println("LOG_TAG_doBackgroundWork_2 thread: ${Thread.currentThread().name}")
    throw Exception("doBackgroundWork")
    return "Result"
}