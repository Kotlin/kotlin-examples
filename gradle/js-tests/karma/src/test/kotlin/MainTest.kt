import kotlin.test.*

class SimpleTest {

    @Test fun testFoo() {
        assertEquals(10, foo())
    }

    @Ignore @Test fun testFooWrong() {
        assertEquals(20, foo())
    }
}

@Ignore
class TestTest {
    @Test fun emptyTest() {
        // Will not run
    }
}
