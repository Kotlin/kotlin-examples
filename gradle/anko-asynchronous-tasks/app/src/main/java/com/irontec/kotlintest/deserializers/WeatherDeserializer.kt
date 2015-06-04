package com.irontec.kotlintest.deserializers

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.irontec.kotlintest.models.WeatherObject
import com.irontec.kotlintest.models.WindObject
import java.lang.reflect.Type

/**
 * Created by axier on 24/4/15.
 */
open class WeatherDeserializer : JsonDeserializer<WeatherObject> {

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): WeatherObject? {
        val jsonObj = json as JsonObject

        val wheather = WeatherObject()
        val wind = WindObject()

        val jsonWeatherArray = jsonObj.getAsJsonArray("weather").get(0)
        val jsonMainObj = jsonObj.getAsJsonObject("main")
        val jsonWindObj = jsonObj.getAsJsonObject("wind")

        wheather.main = jsonWeatherArray.getAsJsonObject().get("main").getAsString()
        wheather.description = jsonWeatherArray.getAsJsonObject().get("description").getAsString()
        wheather.temp = jsonMainObj.get("temp").getAsFloat()
        wheather.temp_Max = jsonMainObj.get("temp_max").getAsFloat()
        wheather.temp_Min = jsonMainObj.get("temp_min").getAsFloat()
        wheather.humidity = jsonMainObj.get("humidity").getAsInt()
        wind.speed = jsonWindObj.get("speed").getAsFloat()
        wind.deg = jsonWindObj.get("deg").getAsFloat()
        wheather.wind = wind

        return wheather

    }
}