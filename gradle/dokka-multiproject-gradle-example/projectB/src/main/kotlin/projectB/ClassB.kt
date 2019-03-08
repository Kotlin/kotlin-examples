package projectB

import projectA.Greeter

/**
 * This class references [Greeter] from ClassA
 *
 * @property name The name of the person to be greeted.
 */
class Welcome(private val name: String) {

    /**
     * Greets the guest
     */
    fun greet() {
        val greeter = Greeter(name)
        greeter.greet()
    }
}

fun main(args: Array<String>) {
    Welcome(args[0]).greet()
}
