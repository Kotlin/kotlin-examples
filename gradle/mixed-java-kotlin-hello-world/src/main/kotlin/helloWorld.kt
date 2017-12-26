package demo

import java.util.*

class KotlinGreetingJoiner(val greeter: Greeter) {

    val names = ArrayList<String?>()

    fun addName(name: String?) {
        names.add(name)
    }

    fun getJoinedGreeting(): String {
        return "${greeter.getGreeting()} ${names.filterNotNull().joinToString(separator = " and ")}"
    }
}
