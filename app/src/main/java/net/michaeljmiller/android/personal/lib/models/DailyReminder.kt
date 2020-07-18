package net.michaeljmiller.android.personal.lib.models

import net.michaeljmiller.android.personal.lib.interfaces.Reminder
import java.text.SimpleDateFormat
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import androidx.room.Entity
import org.json.JSONObject
import java.util.*

@Entity(tableName = "daily_reminders")
data class DailyReminder(
    @ColumnInfo(name = "reference") private val reference: String,
    @ColumnInfo(name = "reminder") private val reminder: String,
    @PrimaryKey private val id: Int?,
    @ColumnInfo(name = "created_at") val created_at : Date?,
    @ColumnInfo(name = "updated_at") val updated_at : Date?
): Reminder {
    constructor(json : JSONObject) : this(
        json.getString("reference"),
        json.getString("reminder"),
        json.get("id") as Int?,
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'", Locale.US).parse(json.getString("created_at")),
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'", Locale.US).parse(json.getString("updated_at"))
    )

    override fun getId(): Int? {
        return id
    }

    override fun getClass(): String {
        return "App\\Models\\DailyReminder"
    }

    override fun getReference(): String {
        return reference
    }

    override fun getReminder(): String {
        return reminder
    }

    override fun getCreatedAt(): Date? {
        return created_at
    }

    override fun getUpdatedAt(): Date? {
        return updated_at
    }
}
