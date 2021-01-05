package net.michaeljmiller.android.personal.lib.models

import java.text.SimpleDateFormat
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import androidx.room.Entity
import org.json.JSONObject
import java.util.*

@Entity(tableName = "quotes")
data class Quote(
    @ColumnInfo(name = "source") val source: String,
    @ColumnInfo(name = "quote") val quote: String,
    @PrimaryKey val id: Int?,
    @ColumnInfo(name = "created_at") val created_at : Date?,
    @ColumnInfo(name = "updated_at") val updated_at : Date?
) {
    constructor(json : JSONObject) : this(
        json.getString("source"),
        json.getString("quote"),
        json.get("id") as Int?,
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'", Locale.US).parse(json.getString("created_at")),
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'", Locale.US).parse(json.getString("updated_at"))
    )
}
