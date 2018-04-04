package net.michaeljmiller.bundles.api.interfaces

import org.json.JSONObject

interface ApiModel {
    val id: Int?
    fun getLabel(): String
    fun buildFromJsonObject(json: JSONObject)
}