package net.michaeljmiller.android.personal.lib.service

import net.michaeljmiller.android.personal.lib.service.http.PersonalWebService

class DailyReminderService() {

    fun get() : DailyReminder {
        return PersonalWebService().getDailyReminder()
    }
}