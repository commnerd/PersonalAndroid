package net.michaeljmiller.android.personal.lib.service

import net.michaeljmiller.android.personal.lib.service.http.personal.DailyReminderEndpoint
import net.michaeljmiller.android.personal.lib.service.http.personal.QuoteEndpoint
import net.michaeljmiller.android.personal.lib.service.http.PersonalWebService
import net.michaeljmiller.android.personal.lib.local.storage.PersonalDatabase
import net.michaeljmiller.android.personal.lib.models.laravel.DailyReminder
import net.michaeljmiller.android.personal.lib.models.Quote
import android.content.Context
import kotlin.random.Random

class DailyReminderService(val context : Context) {

    fun get() : DailyReminder? {
        if (Random.nextBoolean()) {
            return getRandomQuote(context)
        }

        return getRandomReminder(context)
    }

    fun getRandomReminder(context : Context) : DailyReminder {
        val db = PersonalDatabase.getDatabase(context)
        var reminder : DailyReminder?

        if(NetworkService(context).wifiConnected()) {
            reminder = PersonalWebService(DailyReminderEndpoint()).rand()
            if (reminder != null) {
                db.dailyReminderDao().add(reminder)
                return reminder
            }
        }

        reminder = db.dailyReminderDao().random()
        return reminder
    }

    private fun getRandomQuote(context : Context) : DailyReminder? {
        val db = PersonalDatabase.getDatabase(context)
        var reminder : DailyReminder?
        var quote : Quote?

        if(NetworkService(context).wifiConnected()) {
            quote = PersonalWebService(QuoteEndpoint()).rand()
            if (quote != null) {
                db.quoteDao().add(quote)
            }
        }

        quote = db.quoteDao().random()

        reminder = DailyReminder(quote.source, quote.quote, quote.id, quote.created_at, quote.updated_at)

        return reminder
    }
}