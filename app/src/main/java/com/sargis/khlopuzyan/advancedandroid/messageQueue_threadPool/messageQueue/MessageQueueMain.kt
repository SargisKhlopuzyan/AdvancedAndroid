package com.sargis.khlopuzyan.advancedandroid.messageQueue_threadPool.messageQueue

fun main() {
    val messageQueue = MessageQueue()
    //start the looping
    messageQueue.run()

    messageQueue.post(task = Runnable {
        println("LOG_TAG_messageQueue.post")
    })

    // delayed message for 3 second
    messageQueue.postDelay(task = Runnable {
        println("LOG_TAG_messageQueue.postDelay")
    }, 3000)
}