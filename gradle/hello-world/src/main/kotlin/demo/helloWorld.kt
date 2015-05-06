package demo

import com.google.common.base.Joiner
import java.util.ArrayList

fun getGreeting(): String {
    val words = ArrayList<String>()
    words.add("Hello,")
    words.add("world!")

    return Joiner.on(" ").join(words)
}

fun main(args: Array<String>) {
    println(getGreeting())
}
