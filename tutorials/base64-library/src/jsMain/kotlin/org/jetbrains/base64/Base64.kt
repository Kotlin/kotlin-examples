package org.jetbrains.base64

actual object Base64Factory {
    actual fun createEncoder(): Base64Encoder = JsBase64Encoder
}

object JsBase64Encoder : Base64Encoder {
    override fun encode(src: ByteArray): ByteArray {
        val buffer = js("Buffer").from(src)
        val string = buffer.toString("base64") as String
        return ByteArray(string.length) { string[it].toByte() }
    }
}

fun main(args: Array<String>) {
    println(JsBase64Encoder.encodeToString(byteArrayOf(75, 111, 116, 108, 105, 110)))
}
