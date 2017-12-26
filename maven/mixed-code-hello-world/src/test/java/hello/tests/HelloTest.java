package hello.tests;

import hello.JavaHello;
import junit.framework.TestCase;

public class HelloTest extends TestCase {
  public void testAssert() {
    assertEquals("Hello from Kotlin!", JavaHello.getHelloStringFromKotlin());
    assertEquals("Hello from Java!", hello.KotlinHelloKt.getHelloStringFromJava());

    System.out.println(hello.KotlinHelloKt.getHelloStringFromJava());
  }
}
