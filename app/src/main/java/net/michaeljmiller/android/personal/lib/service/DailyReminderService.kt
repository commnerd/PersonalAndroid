package net.michaeljmiller.android.personal.lib.service

import net.michaeljmiller.android.personal.lib.storage.remote.http.PersonalWebService
import net.michaeljmiller.android.personal.lib.storage.local.dao.ReminderDao
import net.michaeljmiller.android.personal.lib.interfaces.Reminder
import android.content.Context

class DailyReminderService(private val context : Context) {

    fun get() : Reminder? {
        var reminder : Reminder? = null

        if(NetworkService(context).wifiConnected()) {
            reminder = PersonalWebService().getDailyReminder()
            val dao = DailyReminderTriageService(context).dAOS[reminder.getClass()] as ReminderDao
            dao.add(reminder)
        }
        return reminder
    }
}