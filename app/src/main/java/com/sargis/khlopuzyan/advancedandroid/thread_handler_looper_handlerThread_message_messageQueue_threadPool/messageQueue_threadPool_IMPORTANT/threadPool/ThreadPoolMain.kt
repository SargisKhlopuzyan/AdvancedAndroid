package com.sargis.khlopuzyan.advancedandroid.thread_handler_looper_handlerThread_message_messageQueue_threadPool.messageQueue_threadPool_IMPORTANT.threadPool

fun main() {
    val threadPool = ThreadPool(3)
    threadPool.submit(runnable = {
        println("LOG_TAG_threadPool")
    })
}