package net.michaeljmiller.android.personal.lib.service

import android.net.ConnectivityManager
import android.content.Context

class NetworkService(private val context : Context) {
    fun wifiConnected() : Boolean {
        val connManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return !connManager!!.isActiveNetworkMetered
    }
}