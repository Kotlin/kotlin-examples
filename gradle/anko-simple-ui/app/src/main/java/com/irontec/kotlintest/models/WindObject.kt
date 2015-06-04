package com.irontec.kotlintest.models

/**
 * Created by axier on 24/4/15.
 */
public class WindObject {

    public var speed: Float = 0.0f
    public var deg: Float = 0.0f

    init {
        println(this.toString())
    }

    override fun toString() = "Speed ${speed}, deg ${deg}"

}