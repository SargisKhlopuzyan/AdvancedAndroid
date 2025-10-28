package com.sargis.khlopuzyan.advancedandroid.service.v2

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.HandlerThread
import android.os.IBinder
import android.os.Message

class MyService : Service() {

    lateinit var handlerThread: HandlerThread

    val handler: Handler by lazy {
        object : Handler(handlerThread.looper) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        handlerThread = HandlerThread("MyHandle rThread")
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(
        intent: Intent?,
        flags: Int,
        startId: Int,
    ): Int {
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        handlerThread.quitSafely()
    }
}