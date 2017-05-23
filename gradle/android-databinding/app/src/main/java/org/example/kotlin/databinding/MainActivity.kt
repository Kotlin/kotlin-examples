package org.example.kotlin.databinding

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import org.example.kotlin.databinding.databinding.ActivityMainBinding
import org.jetbrains.anko.startActivity


class MainActivity : AppCompatActivity() {

    val weather = WeatherData(
            "Saint Petersburg",
            "10 °C",
            "Cloudy with rain and possible thunderstorms",
            "http://loremflickr.com/800/600/city")

    var counter = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.data = weather
    }

    fun changeTemperatureAndImage(view: View) {
        ++counter
        weather.temperature = "$counter °C"
        weather.imageUrl = "http://loremflickr.com/800/600/city?random=$counter"
        weather.notifyChange()
    }

    fun startActivity(view: View) = startActivity<OtherActivity>()
}