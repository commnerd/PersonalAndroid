package net.michaeljmiller.android.personal.lib.storage.remote.http

import java.io.BufferedInputStream
import java.net.HttpURLConnection
import java.io.InputStream
import java.net.URL

open class HttpService(private val baseUrl : URL) {

    fun get() : String {
        val urlConnection =
            baseUrl.openConnection() as HttpURLConnection
        try {
            val inStream: InputStream = BufferedInputStream(urlConnection.inputStream)
            return readStream(inStream as BufferedInputStream)
        } finally {
            urlConnection.disconnect()
        }
    }

    private fun readStream(inStream : BufferedInputStream) : String {
        val contents = ByteArray(1024)

        var bytesRead = 0
        var strFileContents = ""
        while (inStream.read(contents).also { bytesRead = it } != -1) {
            strFileContents += String(contents, 0, bytesRead)
        }

        return strFileContents
    }

}