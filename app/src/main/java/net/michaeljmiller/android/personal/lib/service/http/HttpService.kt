package net.michaeljmiller.android.personal.lib.service.http

import java.io.BufferedInputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

open class HttpService(val baseUrl : URL) {

    constructor(baseUrl : String) : this(URL(baseUrl))

    fun get() : String {
        val urlConnection =
            baseUrl.openConnection() as HttpURLConnection
        try {
            val inStream: InputStream = BufferedInputStream(urlConnection.inputStream)
            val retVal = readStream(inStream as BufferedInputStream)
            return retVal
        } finally {
            urlConnection.disconnect()
        }
    }

    fun readStream(inStream : BufferedInputStream) : String {
        val contents = ByteArray(1024)

        var bytesRead = 0
        var strFileContents = ""
        while (inStream.read(contents).also({ bytesRead = it }) != -1) {
            strFileContents += String(contents, 0, bytesRead)
        }

        return strFileContents
    }

}