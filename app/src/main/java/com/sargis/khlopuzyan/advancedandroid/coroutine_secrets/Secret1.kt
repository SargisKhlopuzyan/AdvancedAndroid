package com.sargis.khlopuzyan.advancedandroid.coroutine_secrets

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.withContext

val supervisorContext = Dispatchers.IO + SupervisorJob() + CoroutineExceptionHandler { _, e ->
//val context = Dispatchers.IO + CoroutineExceptionHandler { _, e ->
    println("CoroutineExceptionHandler -> e: $e")
}
val sScope = CoroutineScope(supervisorContext)

private fun main() = runBlocking {
    supervisorScope {
//    sScope.launch {
        val writeFileJob = launch {
            createTempFile()
        }
        delay(800)
        writeFileJob.cancel()
    }

    delay(1500)
}

private suspend fun createTempFile() {
    try {
        writeLotsOfLines()
    } finally {
        println("Finally block entered!")
//        withContext(NonCancellable) {
        supervisorScope {
            deleteFile()
        }
//        }
    }
}

fun fun1(a: Int, b: Int): Int {
    return doOperation(a, b) { aa, bb ->
        return@doOperation aa + bb
    }
}

fun doOperation(a: Int, b: Int, action: (Int, Int) -> Int): Int {
    return action(a, b)
}

private suspend fun writeLotsOfLines() {
    withContext(Dispatchers.IO) {
        repeat(100_000) {
            delay(10)
            println("Just a temp file $it")
            ensureActive()
        }
    }
}

private suspend fun deleteFile() {
    withContext(Dispatchers.IO) {
        println("File deleted!")
    }
}