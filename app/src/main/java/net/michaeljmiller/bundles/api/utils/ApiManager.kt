package net.michaeljmiller.bundles.api.utils

import net.michaeljmiller.bundles.api.interfaces.ApiActivity
import net.michaeljmiller.DailyReminderActivity
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import org.json.JSONObject
import java.io.IOException
import android.util.Log
import okhttp3.*
import okio.Buffer
import okio.GzipSource
import okio.Okio
import okio.BufferedSource



abstract class ApiManager<T> {
    protected val API_ENDPOINT_PREFIX: String = "https://michaeljmiller.net/api"
    protected var CLIENT: OkHttpClient = OkHttpClient()
    protected val JSON_MEDIATYPE: MediaType? = MediaType.parse("application/json; charset=utf-8")
    private   var HEADERS: Headers? = null
    private   var token: String? = null
    private   var context: ApiActivity? = null

    constructor(context: ApiActivity, token: String?) {
        Log.e("CONSTRUCTOR", context.toString())
        if (context != null) {
            this.context = context
        }
        if (token != null) {
            this.token = token
        }
        var builder = Headers.Builder()
        builder.set("Accept", "application/json")
        builder.set("Content-Type", "application/json")
        if(token != null) {
            builder.set("Authorization", "Bearer $token")
        }
        HEADERS = builder.build()
    }

    abstract protected val ENDPOINT: String

    fun get(endpoint: String?) = call(Request.Builder().get(), endpoint)

    fun post(body: RequestBody, endpoint: String?) = call(Request.Builder().post(body), endpoint)

    fun put(body: RequestBody, endpoint: String?) = call(Request.Builder().put(body), endpoint)

    fun delete(body: RequestBody, endpoint: String?) = call(Request.Builder().delete(body), endpoint)

    private fun call(requestBuilder: Request.Builder, endpoint: String?) {
        val request = buildRequest(requestBuilder, endpoint)

        val requestBuffer = Buffer()
        request.body()!!.writeTo(requestBuffer)
        Log.d("OkHttp", requestBuffer.readUtf8())

        CLIENT.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                // if (response.isSuccessful) {
                    val buffer = Okio.buffer(response.body()!!.source())
                    val content = buffer.readUtf8()
                    Log.d("OkHttp", content)

                    val json = JSONObject(response.body()!!.string())
                    context!!.handleResult(json)
                // }
            }
        })
    }

    private fun buildRequest(requestBuilder: Request.Builder, endpoint: String?): Request {
        if(endpoint == null) {
            Log.d("REQUEST", API_ENDPOINT_PREFIX + ENDPOINT);
            return requestBuilder.headers(HEADERS).url(API_ENDPOINT_PREFIX + ENDPOINT).build()
        }
        return requestBuilder.headers(HEADERS).url(API_ENDPOINT_PREFIX + endpoint).build()
    }
}