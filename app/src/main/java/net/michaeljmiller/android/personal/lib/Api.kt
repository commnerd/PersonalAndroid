package net.michaeljmiller.android.personal.lib

interface Api {
    fun get() : String
    fun post(data : String) : String
}