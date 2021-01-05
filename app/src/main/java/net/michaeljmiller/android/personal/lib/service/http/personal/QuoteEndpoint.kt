package net.michaeljmiller.android.personal.lib.service.http.personal

import net.michaeljmiller.android.personal.lib.service.http.Endpoint
import net.michaeljmiller.android.personal.lib.models.Quote
import org.json.JSONObject

class QuoteEndpoint : Endpoint<Quote>("https://michaeljmiller.net/api/v1/quotes"){
    override fun buildFromJson(obj : JSONObject): Quote? {
        return Quote(obj)
    }
}