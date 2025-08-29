package com.sargis.khlopuzyan.advancedandroid.thread_handler_looper_handlerThread_message_messageQueue_threadPool_2.thread_handler_looper_handlerThread

import android.os.Handler
import android.os.HandlerThread
import android.os.Message
import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

//TODO-URL: https://mfallahpour.medium.com/android-loopers-and-handlers-demystified-481eef1f3984

fun handlerWorkerThread() {
    val handlerWorkerThread = HandlerWorkerThread()

    runBlocking {
        delay(500)
    }
    handlerWorkerThread.execute {
        // Do something
        Log.e(
            "LOG_TAG",
            "handlerWorkerThread.execute_1 ${Thread.currentThread().name}"
        )
    }

    handlerWorkerThread.execute {
        // Do something else
        Log.e(
            "LOG_TAG",
            "handlerWorkerThread.execute_2 ${Thread.currentThread().name}"
        )
    }
}

class HandlerWorkerThread(threadName: String = "HandlerWorkerThread") : HandlerThread(threadName) {

    private lateinit var handler: Handler

    init {
        start()
    }

    override fun onLooperPrepared() {
        Log.e("LOG_TAG", "onLooperPrepared")
//        handler = Handler(Looper.myLooper()!!)
//        handler = Handler()
//        handler = object : Handler(Looper.myLooper()!!) {
        handler = object : Handler(looper) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                Log.e(
                    "LOG_TAG",
                    "onLooperPrepared -> handleMessage -> looper.thread.name: " + looper.thread.name
                )
//                looper.thread.interrupt()
            }
        }
    }

    fun execute(block: () -> Unit) {
        Log.e("LOG_TAG", "execute isInitialized: ${::handler.isInitialized}")
        if (::handler.isInitialized) {
            handler.post {
                block()
            }
        }
    }
}