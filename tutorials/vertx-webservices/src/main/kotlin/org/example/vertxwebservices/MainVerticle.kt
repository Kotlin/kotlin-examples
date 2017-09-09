package org.example.vertxwebservices

import io.vertx.core.AbstractVerticle

/**
 * Bootstraps the program.
 */
@Suppress("unused")
class MainVerticle : AbstractVerticle() {
    override fun start() {
        println("Hello World! :)")
    }

    override fun stop() {
        println("Exiting program...")
    }
}