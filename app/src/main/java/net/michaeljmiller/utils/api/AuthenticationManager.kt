package net.michaeljmiller.utils.api

import okhttp3.RequestBody
import org.json.JSONObject

class AuthenticationManager(token: String?) : ApiManager<String>(token) {

    override val ENDPOINT: String = API_ENDPOINT_PREFIX

    fun login(idToken: String): JSONObject {
        val body = RequestBody.create(JSON_MEDIATYPE, "{\"token\": \"$idToken\"}")
        return super.post(body, "/login")
    }

    fun logout(): JSONObject {
        return super.post(null, "/logout")
    }

    companion object {
        fun login(idToken: String) = AuthenticationManager(null).login(idToken)
        // fun logout() = AuthenticationManager(token).logout()
    }


}