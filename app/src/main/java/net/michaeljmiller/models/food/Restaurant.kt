package net.michaeljmiller.models.food

import net.michaeljmiller.bundles.api.interfaces.ApiModel
import org.json.JSONObject

/**
 * Created by commnerd on 3/13/18.
 */
data class Restaurant(override var id: Int?, var name: String? /*, val created_at: Date, val updated_at: Date */): ApiModel {
    override fun getLabel(): String {
        return name!!
    }

    override fun buildFromJsonObject(json: JSONObject) {
        this.id = json.getInt("id")
        this.name = json.getString("name")
    }
}