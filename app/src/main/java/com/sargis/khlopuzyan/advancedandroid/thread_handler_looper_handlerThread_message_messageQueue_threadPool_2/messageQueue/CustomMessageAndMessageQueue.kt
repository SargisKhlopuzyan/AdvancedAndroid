package com.sargis.khlopuzyan.advancedandroid.thread_handler_looper_handlerThread_message_messageQueue_threadPool_2.messageQueue

import android.util.Log

fun messageAndMessageQueue() {
    val messageQueue = MessageQueue()
    messageQueue.run()

    messageQueue.postDelay({
        Log.e("LOG_TAG", "messageQueue.postDelay 3 seconds")
    }, 3 * 1000)

    messageQueue.post({
        Log.e("LOG_TAG", "messageQueue.post")
    })

    messageQueue.postDelay({
        Log.e("LOG_TAG", "messageQueue.postDelay 2 seconds")
    }, 2 * 1000)
}

data class Message(
    val task: Runnable?,
    val execTime: Long,
) {
    var prev: Message? = null
    var next: Message? = null
}

class MessageQueue {

    var head = Message(null, -1)
    var tail = Message(null, Long.MAX_VALUE)

    init {
        head.next = tail
        tail.prev = head
    }

    fun run() {
        Thread(Runnable {
            while (true) {
                val current: Message? = head.next
                if (current != null && current != tail && System.currentTimeMillis() >= current.execTime) {

                    val next: Message? = current.next

                    current.task?.run()
                    current.next = null
                    current.prev = null

                    head.next = next
                    next?.prev = head
                }
            }
        }).start()
    }

    fun post(task: Runnable) {
        val message = Message(task, System.currentTimeMillis())
        insertMessageInMessageQueue(message)
    }

    fun postDelay(task: () -> Unit, millis: Long) {
        val message = Message(task, System.currentTimeMillis() + millis)
        insertMessageInMessageQueue(message)
    }

    private fun insertMessageInMessageQueue(message: Message) {
        var target: Message? = tail
        while (target != null && target.execTime >= message.execTime) {
            target = target.prev
        }

        val next = target?.next

        message.prev = target
        target?.next = message

        message.next = next
        next?.prev = message
    }
}