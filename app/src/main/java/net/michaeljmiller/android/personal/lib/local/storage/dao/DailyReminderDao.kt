package net.michaeljmiller.android.personal.lib.local.storage.dao

import net.michaeljmiller.android.personal.lib.models.laravel.DailyReminder
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Dao
import androidx.room.OnConflictStrategy

@Dao
interface DailyReminderDao {
    @Query("SELECT * FROM daily_reminders")
    fun list(): List<DailyReminder>

    @Query("SELECT * FROM daily_reminders ORDER BY RANDOM() LIMIT 1")
    fun random(): DailyReminder

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(vararg daily_reminders : DailyReminder)
}