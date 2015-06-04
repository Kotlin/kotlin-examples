package com.irontec.kotlintest.models

/**
 * Created by axier on 21/4/15.
 */

open class CustomPojo (var name: String) {

    init {
        println("Customer initialized with value ${name}")
    }

    override fun toString() = "$name"
}