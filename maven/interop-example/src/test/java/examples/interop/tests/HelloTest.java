package examples.interop.tests;

import examples.interop.JavaHello;
import examples.interop.KotlinHelloKt;
import org.junit.Assert;
import org.junit.Test;

public class HelloTest {

    @Test
    public void shouldRetrieveCorrectStringsViaInterop() {
        Assert.assertEquals("Hello from Kotlin!", JavaHello.getHelloStringFromKotlin());
        Assert.assertEquals("Hello from Java!", KotlinHelloKt.getHelloStringFromJava());
    }

}
