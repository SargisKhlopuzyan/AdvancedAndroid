package com.sargis.khlopuzyan.advancedandroid.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.sargis.khlopuzyan.advancedandroid.R

const val CHANNEL_ID = "running_channel"

//TODO-URL: https://www.youtube.com/watch?v=YZL-_XJSClc&t=3s&ab_channel=PhilippLackner
class RunningService : Service() {

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(
        intent: Intent?,
        flags: Int,
        startId: Int,
    ): Int {
        when (intent?.action) {
            Action.START.toString() -> start()
            Action.STOP.toString() -> {
                println("LOG_TAG RunningService -> stopSelf")
                stopSelf()
            }

        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun start() {
        println("LOG_TAG RunningService -> start")
        val notification = NotificationCompat.Builder(this, "running_channel")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Run is active")
            .setContentText("Elapsed time: 00:50")
            .build()

        startForeground(1, notification)
    }
}

enum class Action {
    START,
    STOP
}