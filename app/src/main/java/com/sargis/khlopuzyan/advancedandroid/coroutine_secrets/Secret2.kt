package com.sargis.khlopuzyan.advancedandroid.coroutine_secrets

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext


private fun main() = runBlocking {
    val writeFileJob = launch {
        createTempFile()
    }
    delay(1000)
    writeFileJob.cancel()
    delay(2500)
}

private suspend fun createTempFile() {
    try {
        writeLotsOfLines()
    } finally {
        println("Finally block entered!")
        withContext(NonCancellable) {
            deleteFile()
        }
    }
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