package com.sargis.khlopuzyan.advancedandroid.thread_handler_looper_handlerThread_message_messageQueue_threadPool_2.thread_handler_looper_handlerThread

import android.os.Handler
import android.os.Looper
import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

//TODO-URL: https://mfallahpour.medium.com/android-loopers-and-handlers-demystified-481eef1f3984

fun looperWorkerThread() {
    val looperWorkerThread = LooperWorkerThread()

    runBlocking {
        delay(500)
    }

    looperWorkerThread.execute {
        // Do something
        Log.e("LOG_TAG", "looperWorkerThread.execute_1 ${Thread.currentThread().name}")
    }

    looperWorkerThread.execute {
        // Do something else
        Log.e("LOG_TAG", "looperWorkerThread.execute_2 ${Thread.currentThread().name}")
    }

    looperWorkerThread.quit()
}

class LooperWorkerThread : Thread("LooperWorkerThread") {

    private lateinit var handler: Handler

    init {
        start()
    }

    override fun run() {
        Looper.prepare()
        handler = Handler(Looper.myLooper()!!)
//        handler = object : Handler(Looper.myLooper()!!) {
//            override fun handleMessage(msg: Message) {
//                super.handleMessage(msg)
//                Log.e("LOG_TAG", "Looper name " + looper.thread.name)
////                looper.thread.interrupt()
//            }
//        }
        Looper.loop()
    }

    fun execute(block: () -> Unit) {
        handler.post {
            Log.e("LOG_TAG", "execute ${currentThread().name}")
            block()
        }
    }

    fun quit() {
        handler.post {
            Looper.myLooper()?.quit()
        }
    }
}