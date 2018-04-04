package net.michaeljmiller.bundles.api.utils

import net.michaeljmiller.bundles.api.interfaces.ApiActivity
import okhttp3.RequestBody

class AuthenticationManager(context: ApiActivity, token: String?) : ApiManager<String>(context, token) {

    override val ENDPOINT: String = API_ENDPOINT_PREFIX

    fun login(idToken: String) {
        val body = RequestBody.create(JSON_MEDIATYPE, "{\"token\": \"$idToken\"}")
        return super.post(body, "/login")
    }

    fun logout() {
        super.get( "/logout")
    }

    companion object {
        fun login(context: ApiActivity, idToken: String) = AuthenticationManager(context, null).login(idToken)
        // fun logout() = AuthenticationManager(token).logout()
    }


}