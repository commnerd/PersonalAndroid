package net.michaeljmiller.android.personal.lib.service.schedule

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import net.michaeljmiller.android.personal.MainActivity
import net.michaeljmiller.android.personal.R

class DailyReminderScheduleReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        context?.let{
            val builder = NotificationCompat.Builder(it, "daily_reminder_channel")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("All your base")
                .setContentText("Are belong to us!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(
                    PendingIntent.getActivity(it, 0, Intent(it, MainActivity::class.java), 0))
                .setAutoCancel(true)

            with(NotificationManagerCompat.from(it)) {
                notify(1, builder.build())
            }
        }
    }
}