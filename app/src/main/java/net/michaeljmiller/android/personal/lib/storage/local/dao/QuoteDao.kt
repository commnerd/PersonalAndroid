package net.michaeljmiller.android.personal.lib.storage.local.dao

import net.michaeljmiller.android.personal.lib.models.DailyReminder
import net.michaeljmiller.android.personal.lib.models.Quote
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Dao
import net.michaeljmiller.android.personal.lib.interfaces.Reminder

@Dao
interface QuoteDao : ReminderDao<Quote> {
    @Query("SELECT * FROM quotes")
    fun list(): List<DailyReminder>

    @Query("SELECT * FROM quotes ORDER BY RANDOM() LIMIT 1")
    override fun random(): Quote

    @Insert
    override fun add(vararg quote : Quote)
}