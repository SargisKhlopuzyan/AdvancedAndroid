package com.sargis.khlopuzyan.advancedandroid.thread_handler_looper_handlerThread_message_messageQueue_threadPool_2.thread_handler_looper_handlerThread

import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.atomic.AtomicBoolean

//TODO-URL: https://mfallahpour.medium.com/android-loopers-and-handlers-demystified-481eef1f3984

//fun main() {
//    val myWorkerThread = MyWorkerThread()
//    myWorkerThread.execute {
//        // Do something
//    }
//    myWorkerThread.execute {
//        // Do something else
//    }
//
//    myWorkerThread.quite()
//}

class MyWorkerThread : Thread() {

    private val isAlive = AtomicBoolean(true)

    private val taskQueue = ConcurrentLinkedQueue<Runnable>()

    init {
        start()
    }

    override fun run() {
        while (isAlive.get()) {
            if (taskQueue.isNotEmpty()) {
                val task: Runnable? = taskQueue.poll()
                task?.run()
            }
        }
    }

    fun execute(block: () -> Unit) {
        taskQueue.add(block)
    }

    fun quite() {
        isAlive.set(false)
    }
}