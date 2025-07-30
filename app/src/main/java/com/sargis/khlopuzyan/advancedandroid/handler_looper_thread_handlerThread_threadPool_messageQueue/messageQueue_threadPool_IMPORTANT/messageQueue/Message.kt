package com.sargis.khlopuzyan.advancedandroid.handler_looper_thread_handlerThread_threadPool_messageQueue.messageQueue_threadPool_IMPORTANT.messageQueue

class Message(runnable: Runnable?, milliSec: Long) {
    var execTime: Long = milliSec
    var task: Runnable? = runnable

    var prev: Message? = null
    var next: Message? = null
}