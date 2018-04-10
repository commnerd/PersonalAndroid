package net.michaeljmiller.bundles.api.interfaces

import org.json.JSONObject

interface ApiModel {
    fun getLabel(): String
    fun buildObjectFromJson(json: String): ApiModel
}