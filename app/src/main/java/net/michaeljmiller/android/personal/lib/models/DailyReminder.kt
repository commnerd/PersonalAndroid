package net.michaeljmiller.android.personal.lib.service

import net.michaeljmiller.android.personal.lib.models.LaravelModel
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

class DailyReminder(
    private var reference : String,
    private var reminder : String,
    id : Int?,
    created_at : Date?,
    updated_at : Date?
    ) : LaravelModel(id, created_at, updated_at) {

    constructor(json : JSONObject) : this(
        json.getString("reference"),
        json.getString("reminder"),
        json.get("id") as Int?,
        SimpleDateFormat(dateFormat, Locale.US).parse(json.getString("created_at")),
        SimpleDateFormat(dateFormat, Locale.US).parse(json.getString("updated_at"))
    )

    fun getReference() : String {
        return reference
    }

    fun getReminder() : String {
        return reminder
    }

    fun setReference(reference : String) {
        this.reference = reference
    }

    fun setReminder(reminder : String) {
        this.reminder = reminder
    }
}
