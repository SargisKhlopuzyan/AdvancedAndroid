package com.sargis.khlopuzyan.advancedandroid.handler_looper_thread_handlerThread_threadPool_messageQueue.thread_looper_handlerThread

import android.os.Handler
import android.os.Looper
import android.os.Message

fun main() {
    val handlerThread = HandlerThread()
    handlerThread.start()

    val customHandler = CustomHandler(handlerThread.looper!!)

    customHandler.obtainMessage().also { msg ->
        msg.what = 101
        customHandler.sendMessage(msg)
    }

}

//TODO-URL: https://medium.com/@vijimscse/thread-looper-handler-thread-android-kotlin-c6edb9a8faec
class HandlerThread(name: String = "Handler Thread") : Thread(name) {

    val looper: Looper?
        get() = Looper.myLooper()

    override fun run() {
        super.run()
        Looper.prepare()

        Looper.loop()
    }
}

class CustomHandler(looper: Looper) : Handler(looper) {
    override fun handleMessage(msg: Message) {
        super.handleMessage(msg)
        println("LOG_TAG_CustomHandler_handleMessage_ Message: ${msg.what}")
    }
}