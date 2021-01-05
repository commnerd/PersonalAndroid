package net.michaeljmiller.android.personal.lib.service.http

import org.json.JSONObject
import java.net.URL

abstract class Endpoint<T>(var url : URL) {

    constructor(url : String) : this(URL(url))

    abstract fun buildFromJson(obj : JSONObject): T?

    fun url() : URL {
        return url
    }

    fun setPage(page: Int) {
        var currentUrl = url.toString();
        var delim: String = "?"

        if (currentUrl.contains("?")) {
            delim = "&";
        }

        currentUrl += delim + "page="+page.toString();

        url = URL(currentUrl)
    }
}