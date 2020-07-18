package net.michaeljmiller.android.personal.lib.storage.local.dao

import net.michaeljmiller.android.personal.lib.interfaces.Reminder

interface ReminderDao {

    fun add(vararg reminders : Reminder)
}