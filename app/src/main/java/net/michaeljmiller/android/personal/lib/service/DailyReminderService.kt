package net.michaeljmiller.android.personal.lib.service

import net.michaeljmiller.android.personal.lib.service.http.PersonalWebService
import net.michaeljmiller.android.personal.lib.local.storage.PersonalDatabase
import net.michaeljmiller.android.personal.lib.models.DailyReminder
import androidx.room.RoomDatabase
import android.content.Context
import androidx.room.Room

class DailyReminderService(val context : Context) {

    fun get() : DailyReminder? {
        val db = PersonalDatabase.getDatabase(context)
        val reminder : DailyReminder?

        if(NetworkService(context).wifiConnected()) {
            reminder = PersonalWebService().getDailyReminder()
            db.dailyReminderDao().add(reminder)
            return reminder
        }

            reminder = db.dailyReminderDao().random()
        return reminder
    }
}