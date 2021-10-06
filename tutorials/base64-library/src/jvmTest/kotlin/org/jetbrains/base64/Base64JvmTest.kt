package org.jetbrains.base64

import org.junit.Test
import kotlin.test.*

class Base64JvmTest {

    @Test
    fun testNonAsciiString() {
        val utf8String = "Gödel"
        val actual = Base64Factory.createEncoder().encodeToString(utf8String.toByteArray())
        assertEquals("R8O2ZGVs", actual)
    }
}