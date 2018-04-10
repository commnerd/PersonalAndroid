package net.michaeljmiller.bundles.api.utils

import net.michaeljmiller.bundles.api.interfaces.ApiActivity
import org.json.JSONObject
import java.io.IOException
import android.util.Log
import okio.Buffer
import okhttp3.*

/**
 * Class to manage API calls
 */
abstract class ApiManager<T> {

    /**
     * Variables
     */
    protected val API_ENDPOINT_PREFIX: String = "https://michaeljmiller.net/api"
    protected val JSON_MEDIATYPE: MediaType? = MediaType.parse("application/json; charset=utf-8")
    protected var CLIENT: OkHttpClient = OkHttpClient()
    private   var context: ApiActivity? = null
    private   var token: String? = null
    private   var HEADERS: Headers? = null

    abstract protected val ENDPOINT: String

    /**
     * Constructor(s)
     */
    constructor(context: ApiActivity, token: String?) {
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

    fun get(endpoint: String?) = call(Request.Builder().get(), endpoint)

    fun post(body: RequestBody, endpoint: String?) = call(Request.Builder().post(body), endpoint)

    fun put(body: RequestBody, endpoint: String?) = call(Request.Builder().put(body), endpoint)

    fun delete(body: RequestBody, endpoint: String?) = call(Request.Builder().delete(body), endpoint)

    private fun call(requestBuilder: Request.Builder, endpoint: String?) {
        val request = buildRequest(requestBuilder, endpoint)

        CLIENT.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val json = JSONObject(response.body()!!.string())
                    context!!.handleResult(json)
                }
            }
        })
    }

    private fun buildRequest(requestBuilder: Request.Builder, endpoint: String?): Request {
        if(endpoint == null) {
            return requestBuilder.headers(HEADERS).url(API_ENDPOINT_PREFIX + ENDPOINT).build()
        }
        return requestBuilder.headers(HEADERS).url(API_ENDPOINT_PREFIX + endpoint).build()
    }
}