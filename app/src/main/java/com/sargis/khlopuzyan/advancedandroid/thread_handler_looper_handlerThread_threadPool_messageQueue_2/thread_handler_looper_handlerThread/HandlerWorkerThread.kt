package com.sargis.khlopuzyan.advancedandroid.thread_handler_looper_handlerThread_threadPool_messageQueue_2.thread_handler_looper_handlerThread

import android.os.Handler
import android.os.HandlerThread
import android.os.Message
import android.util.Log

//TODO-URL: https://mfallahpour.medium.com/android-loopers-and-handlers-demystified-481eef1f3984

class HandlerWorkerThread(threadName: String = "HandlerWorkerThread") : HandlerThread(threadName) {

    private lateinit var handler: Handler

    init {
        start()
    }

    override fun onLooperPrepared() {
        println("LOG_TAG_execute_onLooperPrepared")
//        handler = Handler(Looper.myLooper()!!)
//        handler = Handler()
//        handler = object : Handler(Looper.myLooper()!!) {
        handler = object : Handler(looper) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                Log.d("LOG_TAG", "Looper name " + looper.thread.name)
//                looper.thread.interrupt()
            }
        }
    }

    fun execute(block: () -> Unit) {
        println("LOG_TAG_execute isInitialized: ${::handler.isInitialized}")
        if (::handler.isInitialized) {
            handler.post {
                block()
            }
        }
    }
}