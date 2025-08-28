package com.sargis.khlopuzyan.advancedandroid.thread_handler_looper_handlerThread_message_messageQueue_threadPool_2.threadPool

import android.util.Log
import java.util.LinkedList
import java.util.Queue


fun threadPool() {
    val pool = ThreadPool(5);
    pool.submit({
        Log.e("LOG_TAG", "ThreadPool 1")
    })

    pool.submit({
        Log.e("LOG_TAG", "ThreadPool 2")
    })

    pool.submit({
        Log.e("LOG_TAG", "ThreadPool 3")
    })

    pool.submit({
        Log.e("LOG_TAG", "ThreadPool 4")
    })

    pool.submit({
        Log.e("LOG_TAG", "ThreadPool 5")
    })

    pool.submit({
        Log.e("LOG_TAG", "ThreadPool 6")
    })

    pool.submit({
        Log.e("LOG_TAG", "ThreadPool 7")
    })

    pool.submit({
        Log.e("LOG_TAG", "ThreadPool 8")
    })

    pool.submit({
        Log.e("LOG_TAG", "ThreadPool 9")
    })
}

class ThreadPool(size: Int) {

    private val workerThreads: MutableSet<WorkerThread> = HashSet<WorkerThread>()

    private val queue: Queue<Runnable> = LinkedList<Runnable>()

    init {
        (0 until size).forEach {
            val workerThread = WorkerThread()
            workerThread.start()
            workerThreads.add(workerThread)
        }
    }

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
                    val current: Runnable? = queue.poll()
                    current?.run()
                }
            }
        }
    }
}