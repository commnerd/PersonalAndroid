package net.michaeljmiller.bundles.api.models

import net.michaeljmiller.bundles.api.interfaces.ApiModel
import org.json.JSONObject
import java.util.Date;

class User(
        id: Int,
        var name: String,
        var email: String,
        created_at: Date,
        updated_at: Date
): LaravelModel(id, created_at, updated_at) {
    override fun getLabel(): String {
        return "$name <$email>";
    }

    override fun buildObjectFromJson(json: String): User {
        super.buildObjectFromJson(json)
        val obj = JSONObject(json)
        name = obj.getString("name")
        email = obj.getString("email")
        return this
    }
}