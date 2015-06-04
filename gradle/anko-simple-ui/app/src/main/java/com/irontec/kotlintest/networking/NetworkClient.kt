package com.irontec.kotlintest.networking

import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import java.io.InputStream

/**
 * Created by axier on 23/4/15.
 */
open class NetworkClient {

    fun get(url: String): InputStream {
        val request = Request.Builder().url(url).build()
        val response = OkHttpClient().newCall(request).execute()
        val body = response.body()
        // body.toString() returns a string representing the object and not the body itself, probably
        // kotlins fault when using third party libraries. Use byteStream() and convert it to a String
        return body.byteStream()
    }

}