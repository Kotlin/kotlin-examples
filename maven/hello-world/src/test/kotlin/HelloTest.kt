package hello.tests

import hello.getHelloString
import kotlin.test.assertEquals
import org.junit.Test

class HelloTest {
    @Test fun testAssert() : Unit {
        assertEquals("Hello, world!", getHelloString())
    }
}
