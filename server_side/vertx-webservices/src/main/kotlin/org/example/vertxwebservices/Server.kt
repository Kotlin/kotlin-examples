package org.example.vertxwebservices

import io.vertx.core.AbstractVerticle
import io.vertx.core.Handler
import io.vertx.kotlin.core.http.HttpServerOptions
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
import io.vertx.kotlin.core.json.Json
import io.vertx.kotlin.core.json.obj

/**
 * Bootstraps the program.
 */
@Suppress("unused")
class Server : AbstractVerticle() {
    override fun start() {
        val router = Router.router(vertx)
        val serverOptions = HttpServerOptions(port = 9000, host = "localhost", ssl = false)

        println("Starting HTTP server...")
        setupRoutes(router)
        vertx.createHttpServer(serverOptions).requestHandler { router.accept(it) }.listen()
        println("Server Access: http://${serverOptions.host}:${serverOptions.port}")
    }

    private fun greetingRoute() = Handler<RoutingContext> { ctx ->
        val req = ctx.request()
        val name = if ("name" in req.params()) req.getParam("name") else "World"
        val data = Json.obj(mapOf("greeting" to "Hello $name! :)"))

        with(ctx.response()) {
            statusCode = StatusCode.OK.num
            putHeader("content-type", ContentType.JSON.txt)
            end("${data.encode()}\n")
        }
    }

    private fun setupRoutes(router: Router) {
        router.route("/greeting").handler(greetingRoute())
        router.route("/greeting/:name").handler(greetingRoute())
    }

    override fun stop() {
        println("Stopping HTTP server...")
    }
}