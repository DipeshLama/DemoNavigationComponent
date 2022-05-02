package com.example.navigationcomponent.notificationchannel

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class AppNotification : Application() {
    val channel_1: String = "PaymentNotification"

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(
                channel_1, "PaymentNotification",NotificationManager.IMPORTANCE_HIGH
            )
            channel.description = "Payment success"
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }
}