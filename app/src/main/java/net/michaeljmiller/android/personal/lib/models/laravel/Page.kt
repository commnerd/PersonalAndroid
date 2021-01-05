package net.michaeljmiller.android.personal.lib.models

import org.json.JSONArray
import org.json.JSONObject

data class Page<T>(
    val current_page: Int,
    val data: JSONArray,
    val first_page_url: String,
    val from: Int,
    val last_page: Int,
    val last_page_url: String,
    val links: JSONArray,
    val next_page_url: String,
    val path: String,
    val per_page: Int,
    val prev_page_url: String,
    val to: Int,
    val total: Int
) {
    constructor(json : JSONObject) : this(
        json.getInt("current_page"),
        json.get("data") as JSONArray,
        json.getString("first_page_url"),
        json.getInt("from"),
        json.getInt("last_page"),
        json.getString("last_page_url"),
        json.get("links") as JSONArray,
        json.getString("next_page_url"),
        json.getString("path"),
        json.getInt("per_page"),
        json.getString("prev_page_url"),
        json.getInt("to"),
        json.getInt("total")
    )
}