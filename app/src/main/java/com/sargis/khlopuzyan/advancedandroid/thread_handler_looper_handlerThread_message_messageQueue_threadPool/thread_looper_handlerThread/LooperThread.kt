package com.sargis.khlopuzyan.advancedandroid.thread_handler_looper_handlerThread_message_messageQueue_threadPool.thread_looper_handlerThread

import android.os.Handler
import android.os.Looper
import android.os.Message

//TODO-URL: https://medium.com/@vijimscse/thread-looper-handler-thread-android-kotlin-c6edb9a8faec
class LooperThread : Thread("Custom Thread") {

    lateinit var handler: Handler

    override fun run() {
        super.run()

        Looper.prepare()

        handler = object : Handler(Looper.myLooper()!!) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                println("LOG_TAG_LooperThread_handleMessage_ LooperName: ${looper.thread.name}")
                looper.thread.interrupt()
            }
        }

        Looper.loop()
    }
}

fun main() {
    // We can communicate and post to this LooperThread by using Handler instance from main thread.
    val looperThread = LooperThread()
    looperThread.handler.sendEmptyMessage(100)
}