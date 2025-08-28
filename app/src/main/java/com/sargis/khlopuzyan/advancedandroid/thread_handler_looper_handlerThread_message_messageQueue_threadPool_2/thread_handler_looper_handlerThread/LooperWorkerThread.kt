package com.sargis.khlopuzyan.advancedandroid.thread_handler_looper_handlerThread_message_messageQueue_threadPool_2.thread_handler_looper_handlerThread

import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log

//TODO-URL: https://mfallahpour.medium.com/android-loopers-and-handlers-demystified-481eef1f3984

//fun main() {
//    val looperWorkerThread = LooperWorkerThread()
//    looperWorkerThread.execute {
//        // Do something
//        println("LOG_TAG_execute_1")
//    }
//    looperWorkerThread.execute {
//        // Do something else
//        println("LOG_TAG_execute_2")
//    }
//
//    looperWorkerThread.quite()
//}

class LooperWorkerThread: Thread("LooperWorkerThread") {

    private lateinit var handler: Handler

    init {
        start()
    }

    override fun run() {
        Looper.prepare()
//        handler = Handler(Looper.myLooper()!!)
        handler = object : Handler(Looper.myLooper()!!) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                Log.e("LOG_TAG", "Looper name " + looper.thread.name)
//                looper.thread.interrupt()
            }
        }
        Looper.loop()
    }

    fun execute(block: () -> Unit) {
        handler.post {
            println("LOG_TAG_execute_post ${currentThread().name}")
            block()
        }
    }

    fun quit() {
        handler.post {
            Looper.myLooper()?.quit()
        }
    }
}