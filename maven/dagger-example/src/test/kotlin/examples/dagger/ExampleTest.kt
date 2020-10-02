package examples.dagger

import dagger.Component
import dagger.Module
import dagger.Provides
import org.junit.Test
import javax.inject.Singleton

private var executed = false

class ExampleTest {

    @Singleton
    @Component(modules = [TestCoffeeModule::class])
    interface Coffee {
        fun maker(): CoffeeMaker
    }

    @Module(includes = [PumpModule::class])
    class TestCoffeeModule {

        @Provides
        @Singleton
        fun provideHeater(): Heater {
            return object: ElectricHeater() {
                override fun on() {
                    println("~ psh ~ psh ~ psh ~")
                    println("(from tests)")
                    executed = true
                    super.on()
                }
            }
        }
    }

    @Test
    fun shouldBrewCoffee() {
        val coffee = DaggerExampleTest_Coffee.builder().build()
        coffee.maker().brew()
        assert(executed)
    }

}
