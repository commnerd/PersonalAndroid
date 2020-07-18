package net.michaeljmiller.android.personal.lib.storage.local.dao

import net.michaeljmiller.android.personal.lib.models.DailyReminder
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Dao

@Dao
interface DailyReminderDao {
    @Query("SELECT * FROM daily_reminders")
    fun list(): List<DailyReminder>

    @Query("SELECT * FROM daily_reminders ORDER BY RANDOM() LIMIT 1")
    fun random(): DailyReminder

    @Insert
    fun add(vararg daily_reminders : DailyReminder)
}