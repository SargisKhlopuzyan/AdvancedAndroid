package com.sargis.khlopuzyan.advancedandroid.handler_looper_thread_handlerThread_threadPool_messageQueue.messageQueue_threadPool_IMPORTANT.threadPool

fun main() {
    val threadPool = ThreadPool(3)
    threadPool.submit(runnable = {
        println("LOG_TAG_threadPool")
    })
}