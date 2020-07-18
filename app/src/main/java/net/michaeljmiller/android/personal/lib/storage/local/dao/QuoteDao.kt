package net.michaeljmiller.android.personal.lib.storage.local.dao

import net.michaeljmiller.android.personal.lib.models.DailyReminder
import net.michaeljmiller.android.personal.lib.models.Quote
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Dao

@Dao
interface QuoteDao {
    @Query("SELECT * FROM quotes")
    fun list(): List<DailyReminder>

    @Query("SELECT * FROM quotes ORDER BY RANDOM() LIMIT 1")
    fun random(): DailyReminder

    @Insert
    fun add(vararg quote : Quote)
}