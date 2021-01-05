package net.michaeljmiller.android.personal.lib.service.http

import net.michaeljmiller.android.personal.lib.models.Page
import kotlin.random.Random
import org.json.JSONObject

class PersonalWebService<T>(val endpoint: Endpoint<T>) : HttpService<T>() {

    fun list(page: Int?) : Page<T>
    {
        if(page != null) {
            endpoint.setPage(page)
        }
        val sPage = query(endpoint)
        val jPage = JSONObject(sPage)
        return Page<T>(jPage)
    }

    fun rand() : T? {
        var list = list(null)
        var page : Int
        var index : Int

        if(list.total == 0) {
            return null
        }

        if(list.last_page > 1) {
            page = Random.nextInt(1, list.last_page)
            list = list(page)
        }

        index = Random.nextInt(0, list.data.length() - 1)

        return endpoint.buildFromJson(list.data[index] as JSONObject)
    }

}