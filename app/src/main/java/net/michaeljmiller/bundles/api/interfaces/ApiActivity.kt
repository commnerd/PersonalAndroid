package net.michaeljmiller.bundles.api.interfaces

import org.json.JSONObject

interface ApiActivity {
    fun handleResult(result: JSONObject);
}