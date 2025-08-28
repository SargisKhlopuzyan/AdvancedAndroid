package com.sargis.khlopuzyan.advancedandroid.thread_handler_looper_handlerThread_message_messageQueue_threadPool.thread_looper_handler.v2_IMPORTANT

import android.os.Handler
import android.os.Looper

//TODO-URL: https://mfallahpour.medium.com/android-loopers-and-handlers-demystified-481eef1f3984
class LooperWorkerThread : Thread() {

    private lateinit var handler: Handler

    init {
        start()
    }

    override fun run() {
        super.run()
        Looper.prepare()

        Looper.myLooper()?.let {
            handler = Handler(it)
        }

        Looper.loop()
    }

    fun execute(block: () -> Unit) {
        handler.post {
            block()
        }
    }

    fun quit() {
        Looper.myLooper()?.quit()
    }
}