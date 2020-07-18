package net.michaeljmiller.android.personal.lib.storage.remote.http

import net.michaeljmiller.android.personal.lib.interfaces.Reminder
import net.michaeljmiller.android.personal.lib.models.DailyReminder
import org.json.JSONObject
import java.net.URL

class PersonalWebService(url : URL) : HttpService(url){
    constructor() : this(URL("https://michaeljmiller.net/api/v1/daily_reminder"))

    fun getDailyReminder() : Reminder
    {
        val obj = {

        }
        return DailyReminder(JSONObject(PersonalWebService().get()))
    }
}