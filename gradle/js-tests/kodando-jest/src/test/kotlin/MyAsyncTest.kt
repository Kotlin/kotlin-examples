import kodando.jest.*
import kodando.runtime.async.asyncPromise
import kodando.runtime.async.await
import kotlin.browser.window
import kotlin.js.Promise

object MyAsyncTest {
    init {
        describe("For asynchronous tests") {
            it("should wait for then to continue") {
                val expectedValue = 2

                // simulating some asynchronous operation
                val promisedValue = Promise<Int> { resolve, _ ->
                    window.setTimeout({
                        resolve(expectedValue)
                    }, 3000)
                }

                // we should return a promise to make the jest wait to complete
                asyncPromise {
                    val value = await(promisedValue)

                    expect(value).toBe(2)
                }
            }

            it("and then execute this") {
                expect(true).toBeTruthy()
            }
        }
    }
}