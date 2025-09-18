package com.sargis.khlopuzyan.advancedandroid.thread_handler_looper_handlerThread_message_messageQueue_threadPool.thread_looper_handler.v1

import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.atomic.AtomicBoolean

//TODO-URL https://mfallahpour.medium.com/android-loopers-and-handlers-demystified-481eef1f3984
private fun main() {
    val thread = CustomWorkerThread()
    thread.execute {
        // Do something
        println("LOG_TAG_CustomWorkerThread execute 1")
    }
    thread.execute {
        // Do something else
        println("LOG_TAG_CustomWorkerThread execute 2")
    }
    thread.quit()
}

class CustomWorkerThread : Thread() {

    private val isAlive = AtomicBoolean(true)
    private val taskQueue = ConcurrentLinkedQueue<Runnable>()

    init {
        start()
    }

    override fun run() {
        super.run()
        while (isAlive.get()) {
            val task: Runnable? = taskQueue.poll()
            task?.run()
        }
    }

    fun execute(block: () -> Unit) {
        taskQueue.add(block)
    }

    fun quit() {
        isAlive.set(false)
    }
}