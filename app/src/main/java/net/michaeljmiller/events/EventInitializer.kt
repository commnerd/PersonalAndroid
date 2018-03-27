package net.michaeljmiller.events

import android.content.BroadcastReceiver
import android.app.PendingIntent
import android.app.AlarmManager
import android.content.Context
import android.content.Intent
import java.util.*

/**
 * Created by commnerd on 3/24/18.
 */
class EventInitializer: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val alarmMgr = context!!.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val reminderIntent = Intent(context, DailyReminderBroadcastReceiver::class.java)
        val alarmIntent = PendingIntent.getBroadcast(context, 0, reminderIntent, 0)

        // Set the alarm to start at 5:00 a.m.
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = System.currentTimeMillis()
        calendar.set(Calendar.HOUR_OF_DAY, 5)
        calendar.set(Calendar.MINUTE, 0)

        alarmMgr.setRepeating(AlarmManager.RTC, calendar.timeInMillis, AlarmManager.INTERVAL_DAY, alarmIntent)
    }

}