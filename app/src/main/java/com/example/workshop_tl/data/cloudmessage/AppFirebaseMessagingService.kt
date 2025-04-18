package com.example.workshop_tl.data.cloudmessage

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.workshop_tl.R
import com.example.workshop_tl.presentation.MainActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class AppFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        // Check if message contains a data payload.
        if (remoteMessage.data.isNotEmpty()) {
            Log.d("AppFirebaseMessagingService", "Message data payload: ${remoteMessage.data}")
            handleNow(remoteMessage)
        }

        // Check if message contains a notification payload.
        remoteMessage.notification?.let {
            Log.d("AppFirebaseMessagingService", "Message Notification Body: ${it.body}")
            // You can display a notification here if you want.
            // For example: sendNotification(it.title, it.body)
        }
    }

    private fun handleNow(remoteMessage: RemoteMessage) {
        // Handle message within 10 seconds
        val title = remoteMessage.data["title"]
        val body = remoteMessage.data["body"]
        sendNotification(title, body)
    }

    /**
     * Create and show a simple notification containing the received FCM message.
     *
     * @param messageBody FCM message body received.
     */
    private fun sendNotification(title: String?, messageBody: String?) {
        // TODO: Implement code to show a system notification.
        // You will need to create a Notification Channel for Android 8.0 (Oreo) and higher
        // https://developer.android.com/develop/ui/views/notifications/build-notification#builder
        // Example:  (requires notification setup)
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(
            this, 0, intent,
            PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE
        )

        val channelId = getString(R.string.default_notification_channel_id)
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(android.R.drawable.stat_notify_chat)
            .setContentTitle(title ?: "Default Title")
            .setContentText(messageBody ?: "Default Body")
            .setAutoCancel(true)
            .setSound(defaultSoundUri)
            .setContentIntent(pendingIntent)

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Channel human readable title",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }

        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build())
        Log.d("AppFirebaseMessagingService", "sendNotification($title, $messageBody)")
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("AppFirebaseMessagingService", "Refreshed token: $token")
    }
}