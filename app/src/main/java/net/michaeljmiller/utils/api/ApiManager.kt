package net.michaeljmiller.utils.api

import android.content.Intent
import net.michaeljmiller.DailyReminderActivity
import java.io.IOException
import org.json.JSONObject
import okhttp3.*

abstract class ApiManager<T>(token: String?) {
    protected val API_ENDPOINT_PREFIX: String = "https://michaeljmiller.net/api"
    protected var CLIENT: OkHttpClient = OkHttpClient()
    protected val JSON_MEDIATYPE: MediaType? = MediaType.parse("application/json; charset=utf-8")
    private   val HEADERS: Headers = Headers.Builder().set("Authorization", "Bearer $token").build()

    abstract protected val ENDPOINT: String

    fun get(endpoint: String?) = call(Request.Builder().get(), endpoint);

    fun post(body: RequestBody?, endpoint: String?) = call(Request.Builder().post(body), endpoint)

    fun put(body: RequestBody?, endpoint: String?) = call(Request.Builder().put(body), endpoint)

    fun delete(body: RequestBody?, endpoint: String?) = call(Request.Builder().delete(body), endpoint)

    private fun call(requestBuilder: Request.Builder, endpoint: String?): JSONObject {
        val request = requestBuilder.headers(HEADERS).url(ENDPOINT + endpoint!!).build()
        var result = JSONObject();

        /*
        CLIENT.newCall(request).execute().use({ response ->
            // if (!response.isSuccessful()) throw IOException("Unexpected code $response")
            if(response.isSuccessful()) {
                result = JSONObject(response.body()!!.string())
            }
        })
        */

        return JSONObject("{\"token\": \"abcdefg\"}")

        return result
    }
}