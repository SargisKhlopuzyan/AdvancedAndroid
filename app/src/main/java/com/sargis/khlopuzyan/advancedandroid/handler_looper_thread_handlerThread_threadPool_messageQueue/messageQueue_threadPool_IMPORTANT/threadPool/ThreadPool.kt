package com.sargis.khlopuzyan.advancedandroid.handler_looper_thread_handlerThread_threadPool_messageQueue.messageQueue_threadPool_IMPORTANT.threadPool

import java.util.LinkedList

// TODO-URL: https://medium.com/@qingzhong/the-message-queue-design-weve-been-missing-in-android-development-b9dc10ea45c7
class ThreadPool(size: Int) {

    // Use a set or other data structure to store the threads in case later we need those references.
    private var threads: MutableSet<WorkerThread> = mutableSetOf<WorkerThread>()

    private var queue: LinkedList<Runnable> = LinkedList<Runnable>()

    init {
        repeat(size) {
            val thread = WorkerThread()
            thread.start()
            threads.add(thread)
        }
    }

    // submit a runnable and put it into the thread pool
    fun submit(runnable: Runnable) {
        synchronized(queue) {
            queue.add(runnable)
        }
    }

    private inner class WorkerThread : Thread() {
        override fun run() {
            super.run()
            while (true) {
                synchronized(queue) {
                    val current = queue.poll()
                    current?.run()
                }
            }
        }
    }
}