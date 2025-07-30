package com.sargis.khlopuzyan.advancedandroid.messageQueue_threadPool.threadPool

fun main() {
    val threadPool = ThreadPool(3)
    threadPool.submit(runnable = {
        println("LOG_TAG_threadPool")
    })
}