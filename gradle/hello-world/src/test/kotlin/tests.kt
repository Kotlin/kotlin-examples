package demo 

import kotlin.test.assertEquals
import org.junit.Test as test

class TestSource {
    test fun f() {
        assertEquals("Hello, world!", getGreeting())
    }
}
