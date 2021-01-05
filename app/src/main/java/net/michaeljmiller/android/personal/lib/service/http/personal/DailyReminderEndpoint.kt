package net.michaeljmiller.android.personal.lib.service.http.personal

import net.michaeljmiller.android.personal.lib.models.laravel.DailyReminder
import net.michaeljmiller.android.personal.lib.service.http.Endpoint
import org.json.JSONObject

class DailyReminderEndpoint : Endpoint<DailyReminder>("https://michaeljmiller.net/api/v1/reminders"){
    override fun buildFromJson(obj : JSONObject): DailyReminder? {
        return DailyReminder(obj)
    }
}