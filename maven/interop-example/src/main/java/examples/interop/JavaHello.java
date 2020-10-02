package examples.interop;

public class JavaHello {

    public static String JavaHelloString = "Hello from Java!";

    public static String getHelloStringFromKotlin() {
        return KotlinHelloKt.getKotlinHelloString();
    }

}
