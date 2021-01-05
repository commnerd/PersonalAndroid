package net.michaeljmiller.android.personal.lib.local.storage.dao

import net.michaeljmiller.android.personal.lib.models.Quote
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Dao
import androidx.room.OnConflictStrategy

@Dao
interface QuoteDao {
    @Query("SELECT * FROM quotes")
    fun list(): List<Quote>

    @Query("SELECT * FROM quotes ORDER BY RANDOM() LIMIT 1")
    fun random(): Quote

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(vararg quotes : Quote)
}