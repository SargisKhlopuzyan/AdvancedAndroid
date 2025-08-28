package com.sargis.khlopuzyan.advancedandroid.thread_handler_looper_handlerThread_message_messageQueue_threadPool.thread_looper_handler.v2_IMPORTANT

import android.os.Handler
import android.os.HandlerThread

//TODO-URL: https://mfallahpour.medium.com/android-loopers-and-handlers-demystified-481eef1f3984
class HandlerWorkerThread(threadName: String): HandlerThread(threadName) {

    private lateinit var handler: Handler

    init {
        start()
    }

    override fun onLooperPrepared() {
        super.onLooperPrepared()
        handler = Handler(looper)
    }

    fun execute(block: () -> Unit) {
        if (::handler.isInitialized) {
            handler.post {
                block()
            }
        }
    }
}