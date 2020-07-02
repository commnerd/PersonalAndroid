package net.michaeljmiller.android.personal.lib.service.http

import java.net.URL

class PersonalWebService(url : URL) : HttpService(url){
    constructor(url : String) : this(URL(url))
    constructor() : this(URL("https://michaeljmiller.net/api/v1/daily_reminder"))
}