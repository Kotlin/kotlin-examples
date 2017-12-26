import kotlin.browser.document
import kotlin.browser.window

fun main(args: Array<String>) {
    window.onload = {
        document.body!!.append(document.createElement("div").apply {
            textContent = "Hello, world!"
        })
    }
}