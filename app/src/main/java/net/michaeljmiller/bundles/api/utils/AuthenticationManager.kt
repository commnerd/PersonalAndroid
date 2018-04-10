package net.michaeljmiller.bundles.api.utils

import net.michaeljmiller.bundles.api.interfaces.ApiActivity
import okhttp3.RequestBody

class AuthenticationManager(val context: ApiActivity, val token: String?) : ApiManager<String>(context, token) {

    override val ENDPOINT: String = API_ENDPOINT_PREFIX

    fun login(token: String) {
        val body = RequestBody.create(JSON_MEDIATYPE, "{\"token\": \"$token\"}")
        return super.post(body, "/login")
    }

    fun logout() {
        super.get( "/logout")
    }
}