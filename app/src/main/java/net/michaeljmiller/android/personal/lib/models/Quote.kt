package net.michaeljmiller.android.personal.lib.models

import net.michaeljmiller.android.personal.lib.interfaces.Reminder
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import androidx.room.Entity
import java.util.*

@Entity(tableName = "quotes")
data class Quote(
    @ColumnInfo(name = "source") val source: String,
    @ColumnInfo(name = "quote") val quote: String,
    @PrimaryKey private val id: Int?,
    @ColumnInfo(name = "created_at") val created_at : Date?,
    @ColumnInfo(name = "updated_at") val updated_at : Date?
): Reminder {
    override fun getId(): Int? {
        return id
    }

    override fun getClass(): String {
        return "App\\Models\\Quote"
    }

    override fun getReference(): String {
        return source
    }

    override fun getReminder(): String {
        return quote
    }

    override fun getCreatedAt(): Date? {
        return created_at
    }

    override fun getUpdatedAt(): Date? {
        return updated_at
    }
}
