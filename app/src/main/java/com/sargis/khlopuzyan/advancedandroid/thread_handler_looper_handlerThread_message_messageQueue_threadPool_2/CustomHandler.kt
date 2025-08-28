package com.sargis.khlopuzyan.advancedandroid.thread_handler_looper_handlerThread_message_messageQueue_threadPool_2

import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.os.Message
import android.util.Log
import java.util.LinkedList
import java.util.Queue



//TODO-URL: https://medium.com/@vijimscse/thread-looper-handler-thread-android-kotlin-c6edb9a8faec

private lateinit var handlerThread: HandlerThread
private lateinit var customHandler: CustomHandler

fun customHandlerMain() {
    handlerThread = HandlerThread("CustomHandlerThread").apply {
        start()
        customHandler = CustomHandler(this.looper)
    }

    customHandler.obtainMessage().also { msg ->
        msg.what = 101
        customHandler.sendMessage(msg)
    }
}

fun customHandlerSendMessage() {
    val message = Message()
    message.what = 102
    customHandler.sendMessage(message)
}

class CustomHandler(looper: Looper): Handler(looper) {
    override fun handleMessage(msg: Message) {
        super.handleMessage(msg)
        Log.e("LOG_TAG", "Inside handle message " + msg.what)
    }
}

var requestQueue: Queue<Any> = LinkedList<Any>()
var requestQueue2: LinkedList<Any> = LinkedList<Any>()
