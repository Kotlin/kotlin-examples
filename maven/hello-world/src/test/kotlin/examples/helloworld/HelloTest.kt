package examples.helloworld

import org.junit.Assert
import org.junit.Test

class HelloTest {

    @Test
    fun shouldReturnCorrectString() {
        Assert.assertEquals("Hello, world!", getHelloString())
    }

}
