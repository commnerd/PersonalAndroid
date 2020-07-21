package net.michaeljmiller.android.personal.lib.storage.local.dao

import net.michaeljmiller.android.personal.lib.interfaces.Reminder
import androidx.room.Dao

@Dao
interface ReminderDao<T> {
    fun random(): T
    fun add(vararg reminders : T)
}