package org.example.kotlin.databinding

import android.databinding.ViewDataBinding
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.databinding.DataBindingUtil


class OtherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val items = listOf(
                WeatherData(
                        "Saint Petersburg",
                        "10 °C",
                        "Cloudy with rain and possible thunderstorms",
                        "http://loremflickr.com/800/600/city?random=2"),
                WeatherData(
                        "Munich",
                        "23 °C",
                        "Partly sunny and delightful",
                        "http://loremflickr.com/800/600/city?random=3"),
                WeatherData(
                        "Novosibirsk",
                        "9 °C",
                        "Mostly cloudy",
                        "http://loremflickr.com/800/600/city?random=4"))

        val recyclerView: RecyclerView = findViewById(R.id.weather_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = WeatherAdapter(items)
    }

    class WeatherAdapter(val data: List<WeatherData>): RecyclerView.Adapter<WeatherViewHolder>() {
        override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
            holder.bind(data[position])
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding: ViewDataBinding =
                    DataBindingUtil.inflate(layoutInflater, R.layout.weather_row, parent, false)

            return WeatherViewHolder(binding)
        }

        override fun getItemCount(): Int = data.size
    }

    class WeatherViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Any) {
            binding.setVariable(BR.data, data)
            binding.executePendingBindings()
        }
    }
}
