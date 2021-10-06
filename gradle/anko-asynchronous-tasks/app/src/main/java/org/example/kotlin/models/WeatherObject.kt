package org.example.kotlin.models


/**
 * Created by axier on 24/4/15.
 */
class WeatherObject {

    var main: String = ""
    var description: String = ""
    var temp: Float = 0.0f
    var tempMax: Float = 0.0f
    var tempMin: Float = 0.0f
    var humidity: Int = 0
    var wind: WindObject? = null

    init {
        println(this.toString())
    }

    override fun toString() =
            "Main ${main}\n" +
            "description ${description}\n" +
            "temp ${temp}\n" +
            "temp_Max ${tempMax}\n" +
            "temp_Min ${tempMin}\n" +
            "humidity ${humidity}\n" +
            "wind ${wind.toString()}"

}