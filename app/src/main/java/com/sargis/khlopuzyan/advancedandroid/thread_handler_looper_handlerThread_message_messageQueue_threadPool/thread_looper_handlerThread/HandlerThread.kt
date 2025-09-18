package com.sargis.khlopuzyan.advancedandroid.thread_handler_looper_handlerThread_message_messageQueue_threadPool.thread_looper_handlerThread

import android.os.Handler
import android.os.Looper
import android.os.Message

private fun main() {
    val handlerThread = HandlerThread()
    handlerThread.start()

    val customHandler = CustomHandler(handlerThread.looper!!)

    customHandler.obtainMessage().also { msg ->
        msg.what = 101
        customHandler.sendMessage(msg)
    }

}

//TODO-URL: https://medium.com/@vijimscse/thread-looper-handler-thread-android-kotlin-c6edb9a8faec
private class HandlerThread(name: String = "Handler Thread") : Thread(name) {

    val looper: Looper?
        get() = Looper.myLooper()

    override fun run() {
        super.run()
        Looper.prepare()

        Looper.loop()
    }
}

private class CustomHandler(looper: Looper) : Handler(looper) {
    override fun handleMessage(msg: Message) {
        super.handleMessage(msg)
        println("LOG_TAG_CustomHandler_handleMessage_ Message: ${msg.what}")
    }
}