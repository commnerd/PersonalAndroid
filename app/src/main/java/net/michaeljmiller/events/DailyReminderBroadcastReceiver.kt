package net.michaeljmiller.events

import net.michaeljmiller.utils.DailyReminder
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

/**
 * Created by commnerd on 3/24/18.
 */
class DailyReminderBroadcastReceiver:BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        DailyReminder(context!!).run()
    }

}