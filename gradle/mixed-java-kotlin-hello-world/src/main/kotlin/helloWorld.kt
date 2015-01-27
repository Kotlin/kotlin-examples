package demo

import com.google.common.base.Joiner
import java.util.ArrayList

class KotlinGreetingJoiner(val greeter: Greeter) {

    val names = ArrayList<String?>()

    fun addName(name: String?) {
        names.add(name)
    }

    fun getJoinedGreeting(): String {
        val joiner = Joiner.on(" and ").skipNulls()
        return "${greeter.getGreeting()} ${joiner.join(names)}"
    }
}
