package org.example.kotlin.models

/**
 * Created by axier on 24/4/15.
 */
class WindObject {

    var speed: Float = 0.0f
    var deg: Float = 0.0f

    init {
        println(this.toString())
    }

    override fun toString() = "Speed ${speed}, deg ${deg}"

}