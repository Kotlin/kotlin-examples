import kodando.jest.*

object CalculatorTest {
    init {
        describe("My awesome calculator") {
            val calculator = Calculator()

            it("should sum two numbers") {
                val a = 1
                val b = 2
                val result = calculator.sum(a, b)

                expect(result).toBe(a + b)
            }

            it("should subtract two numbers") {
                val a = 1
                val b = 2
                val result = calculator.subtract(a, b)

                expect(result).toBe(a - b)
            }

            it("should fail too") {
                calculator.multiply(1, 2)
            }
        }
    }
}
