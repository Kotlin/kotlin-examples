package org.jetbrains.base64

/**
 * Encoder interface which can encode byte arrays to Base64 format.
 */
interface Base64Encoder {
    fun encode(src: ByteArray): ByteArray

    fun encodeToString(src: ByteArray): String {
        val encoded = encode(src)
        return buildString(encoded.size) {
            encoded.forEach { append(it.toChar()) }
        }
    }
}

expect object Base64Factory {
    /**
     * Creates a new instance of [Base64Encoder]
     */
    fun createEncoder(): Base64Encoder
}
