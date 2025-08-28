package com.sargis.khlopuzyan.advancedandroid.thread_handler_looper_handlerThread_message_messageQueue_threadPool.messageQueue_threadPool_IMPORTANT.messageQueue

// TODO-URL: https://medium.com/@qingzhong/the-message-queue-design-weve-been-missing-in-android-development-b9dc10ea45c7
class MessageQueue {

    // We need to maintain two "dummy" messages for head and tail.
    // By having these two we don't have to do null check when inserting a new message.
    // The code can be cleaner by using this trick

    // We set dummy head execTime to -1 while tail has MAX_VALUE,
    // we can guarantee any valid message will fall between these two.

    private val head = Message(null, -1)
    private val tail = Message(null, Long.Companion.MAX_VALUE)

    fun run() {
        Thread(Runnable {
            while (true) {
                val current = head.next
                if (current != tail && current != null && System.currentTimeMillis() >= current.execTime) {

                    val next: Message? = current.next
                    current.task?.run()

                    current.next = null
                    current.prev = null

                    head.next = next
                    next?.prev = head
                }
            }
        })
    }

    //if we just need to post it, we put it just before the tail
    fun post(task: Runnable) {
        val message = Message(task, System.currentTimeMillis())

        val prev: Message? = tail.prev

        prev?.next = message
        message.prev = prev

        message.next = tail
        tail.prev = message
    }

    fun postDelay(task: Runnable, milliSec: Long) {

        // if its an delayed message, its execTime is current time plus the delay
        val message = Message(task, System.currentTimeMillis() + milliSec)

        var target: Message? = tail

        while (target != null && target.execTime >= message.execTime) {
            target = target.prev
        }

        val next: Message? = target?.next

        message.prev = target
        target?.next = message

        message.next = next
        next?.prev = message
    }
}