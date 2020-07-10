package net.michaeljmiller.android.personal.lib.service

import android.content.Context
import android.net.ConnectivityManager


class NetworkService(val context : Context) {
    fun wifiConnected() : Boolean {
        val connManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return !connManager!!.isActiveNetworkMetered
    }
}