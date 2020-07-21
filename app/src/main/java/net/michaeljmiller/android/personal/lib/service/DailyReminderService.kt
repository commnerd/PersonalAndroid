package net.michaeljmiller.android.personal.lib.service

import net.michaeljmiller.android.personal.lib.storage.remote.http.PersonalWebService
import net.michaeljmiller.android.personal.lib.storage.local.dao.ReminderDao
import net.michaeljmiller.android.personal.lib.interfaces.Reminder
import android.content.Context
import net.michaeljmiller.android.personal.lib.storage.local.PersonalDatabase
import java.util.*

class DailyReminderService(private val context : Context) {

    private val db = PersonalDatabase.getDatabase(context)

    val dAOS = mapOf(
        "App\\Models\\DailyReminder" to db.dailyReminderDao(),
        "App\\Models\\Quote" to db.quoteDao()
    )

    fun get() : Reminder? {
        if(NetworkService(context).wifiConnected()) {
            return getFromApi()
        }
        return getFromDb()
    }

    private fun getFromApi() : Reminder? {
        val reminder = PersonalWebService().getDailyReminder()
        val dao = dAOS[reminder.getClass()] as ReminderDao<in Any>
        dao.add(reminder)
        return reminder
    }

    private fun getFromDb() : Reminder? {
        val dao = getRandomReminderDao()
        return dao.random()
    }

    private fun getRandomReminderDao() : ReminderDao<out Reminder> {
        val random = Random()
        return dAOS.entries.elementAt(random.nextInt(dAOS.size)).value
    }
}