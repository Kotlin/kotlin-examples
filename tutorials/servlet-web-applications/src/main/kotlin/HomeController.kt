package org.jetbrains.kotlin.demo

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "Hello", value = ["/hello"])
class HomeController : HttpServlet() {
    override fun doGet(req: HttpServletRequest, res: HttpServletResponse) {
        res.writer.write("Hello, World!")
    }
}