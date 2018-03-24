package net.michaeljmiller.notifications

import android.annotation.TargetApi
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.ContextWrapper
import android.graphics.Color
import net.michaeljmiller.R

/**
 * Helper class to manage notification channels, and create notifications.
 */
@TargetApi(26)
class NotificationHelper(ctx: Context): ContextWrapper(ctx) {

    private var manager: NotificationManager? = null

    /**
     * Get the small icon for this app
     *
     * @return The small icon resource id
     */
    private val smallIcon: Int
        get() = android.R.drawable.stat_notify_chat

    init {

        val chan1 = NotificationChannel(PRIMARY_CHANNEL,
                getString(R.string.default_channel_name), NotificationManager.IMPORTANCE_DEFAULT)
        chan1.lightColor = Color.GREEN
        chan1.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        getManager().createNotificationChannel(chan1)
    }

    /**
     * Get a notification of type 1
     *
     * Provide the builder rather than the notification it's self as useful for making notification
     * changes.
     *
     * @param title the title of the notification
     * @param body the body text for the notification
     * @return the builder as it keeps a reference to the notification (since API 24)
     */
    fun buildNotification(title: String, body: String): Notification.Builder {
        return Notification.Builder(applicationContext, PRIMARY_CHANNEL)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(smallIcon)
                .setAutoCancel(true)
    }

    /**
     * Send a notification.
     *
     * @param id The ID of the notification
     * @param notification The notification object
     */
    fun notify(notification: Notification.Builder) {
        getManager().notify(1100, notification.build())
    }

    /**
     * Get the notification manager.
     *
     * Utility method as this helper works with it a lot.
     *
     * @return The system service NotificationManager
     */
    private fun getManager(): NotificationManager {
        if (manager == null) {
            manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        }
        return manager as NotificationManager
    }

    companion object {
        val PRIMARY_CHANNEL = "Michael J. Miller"
    }
}