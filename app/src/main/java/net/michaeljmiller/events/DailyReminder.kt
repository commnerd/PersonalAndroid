package net.michaeljmiller.events

import net.michaeljmiller.notifications.NotificationHelper
import net.michaeljmiller.DailyReminderActivity
import android.content.BroadcastReceiver
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import org.json.JSONObject
import java.io.IOException
import okhttp3.*

/**
 * Created by commnerd on 3/24/18.
 */
class DailyReminder:BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        // avoid creating several instances, should be singleon
        val client = OkHttpClient()

        val request = Request.Builder()
                .url("https://michaeljmiller.net/api/daily_reminder")
                .build()

        val noti = NotificationHelper(context!!)

        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace();
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val notifyIntent = Intent(context, DailyReminderActivity::class.java)
                    val json = JSONObject(response.body()!!.string())
                    val reference = json.getString("reference")
                    val reminder = json.getString("reminder")

                    notifyIntent.putExtra("reference", reference)
                    notifyIntent.putExtra("reminder", reminder)

                    // Set the Activity to start in a new, empty task
                    notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)

                    // Create the PendingIntent
                    val notifyPendingIntent = PendingIntent.getActivity(
                            context, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT
                    )

                    val notification = noti.buildNotification(reference, reminder)
                    notification.setContentIntent(notifyPendingIntent)
                    noti.notify(notification)
                }
            }
        })
    }

}