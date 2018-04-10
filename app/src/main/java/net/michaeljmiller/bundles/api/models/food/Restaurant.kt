package net.michaeljmiller.bundles.api.models.food

import net.michaeljmiller.bundles.api.models.LaravelModel
import org.json.JSONObject

/**
 * Created by commnerd on 3/13/18.
 */
import java.util.Date;

class Restaurant(
        id: Int?,
        var name: String,
        created_at: Date?,
        updated_at: Date?
): LaravelModel(id, created_at, updated_at) {
    override fun getLabel(): String {
        return name
    }

    override fun buildObjectFromJson(json: String): Restaurant {
        super.buildObjectFromJson(json)
        val obj = JSONObject(json)
        name = obj.getString("name")
        return this
    }
}