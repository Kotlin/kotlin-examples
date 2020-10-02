package examples.interop

val KotlinHelloString : String = "Hello from Kotlin!"

fun getHelloStringFromJava() : String {
    return JavaHello.JavaHelloString!!;
}
