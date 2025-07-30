package com.sargis.khlopuzyan.advancedandroid.messageQueue_threadPool.messageQueue

class Message(runnable: Runnable?, milliSec: Long) {
    var execTime: Long = milliSec
    var task: Runnable? = runnable

    var prev: Message? = null
    var next: Message? = null
}