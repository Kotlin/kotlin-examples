package com.irontec.kotlintest.models

/**
 * Created by axier on 24/4/15.
 */
public class WeatherObject {

    public var main: String = ""
    public var description: String = ""
    public var temp: Float = 0.0f
    public var temp_Max: Float = 0.0f
    public var temp_Min: Float = 0.0f
    public var humidity: Int = 0
    public var wind: WindObject? = null

    init {
        println(this.toString())
    }

    override fun toString() =
            "Main ${main}, description ${description}, temp ${temp}, temp_Max ${temp_Max}," +
                ", temp_Min ${temp_Min}, humidity ${humidity}, wind ${wind.toString()}"

}