package net.michaeljmiller.android.personal.lib.models.laravel

import java.text.SimpleDateFormat
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import androidx.room.Entity
import org.json.JSONObject
import java.util.*

@Entity(tableName = "daily_reminders")
data class DailyReminder(
    @ColumnInfo(name = "reference") val reference: String,
    @ColumnInfo(name = "reminder") val reminder: String,
    @PrimaryKey val id: Int?,
    @ColumnInfo(name = "created_at") val created_at : Date?,
    @ColumnInfo(name = "updated_at") val updated_at : Date?
) {
    constructor(json : JSONObject) : this(
        json.getString("reference"),
        json.getString("reminder"),
        json.get("id") as Int?,
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'", Locale.US).parse(json.getString("created_at")),
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'", Locale.US).parse(json.getString("updated_at"))
    )
}
