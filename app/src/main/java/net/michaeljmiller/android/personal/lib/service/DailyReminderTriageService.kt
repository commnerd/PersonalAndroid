package net.michaeljmiller.android.personal.lib.service

import net.michaeljmiller.android.personal.lib.storage.local.PersonalDatabase
import android.content.Context

class DailyReminderTriageService(context: Context) {

    private val db = PersonalDatabase.getDatabase(context)

    val dAOS = mapOf(
        "App\\Models\\DailyReminder" to db.dailyReminderDao(),
        "App\\Models\\Quote" to db.quoteDao()
    )
}