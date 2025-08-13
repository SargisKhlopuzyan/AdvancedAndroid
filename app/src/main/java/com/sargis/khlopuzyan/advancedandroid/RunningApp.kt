package com.sargis.khlopuzyan.advancedandroid

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.util.Log
import com.sargis.khlopuzyan.advancedandroid.service.CHANNEL_ID

class RunningApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.e("LOG_TAG", "RunningApp -> onCreate")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            println("LOG_TAG RunningApp -> onCreate")
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Running Notifications",
                NotificationManager.IMPORTANCE_HIGH
            )
            channel.description = "RunningService channel"

            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
//            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }
}