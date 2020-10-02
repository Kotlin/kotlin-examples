package org.kotlintestmpp

fun main(args : Array<String>) {
    console.log("Hello, world!")
}

fun js(){}
fun shared(){}

actual fun getCurrentDate(): String {
    return "test"
}

fun String.myExtension() = println("test")