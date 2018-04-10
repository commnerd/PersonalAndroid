package net.michaeljmiller.bundles.api.models

import net.michaeljmiller.bundles.api.interfaces.ApiModel
import org.json.JSONObject
import java.util.Date

abstract class LaravelModel(
        var id: Int?,
        var created_at: Date?,
        var updated_at: Date?
): ApiModel {
    override fun buildObjectFromJson(json: String): ApiModel {
        var obj = JSONObject(json)
        id = obj.getInt("id")
        // created_at = Date(obj.getString("created_at"))
        // updated_at = Date(obj.getString("created_at"))
    }
}