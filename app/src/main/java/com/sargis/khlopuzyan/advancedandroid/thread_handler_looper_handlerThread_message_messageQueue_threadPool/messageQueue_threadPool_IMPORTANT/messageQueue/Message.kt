package com.sargis.khlopuzyan.advancedandroid.thread_handler_looper_handlerThread_message_messageQueue_threadPool.messageQueue_threadPool_IMPORTANT.messageQueue

class Message(runnable: Runnable?, milliSec: Long) {
    var execTime: Long = milliSec
    var task: Runnable? = runnable

    var prev: Message? = null
    var next: Message? = null
}