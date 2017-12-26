package org.example.kotlin.databinding

import android.databinding.BaseObservable

class WeatherData(
        var location: String,
        var temperature: String,
        var info: String,
        var imageUrl: String
) : BaseObservable()