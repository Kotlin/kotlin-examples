package com.irontec.kotlintest

import android.app.Activity
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.irontec.kotlintest.deserializers.WeatherDeserializer
import com.irontec.kotlintest.models.WeatherObject
import com.irontec.kotlintest.networking.NetworkClient
import org.json.JSONObject
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import org.jetbrains.anko.*


public class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super<AppCompatActivity>.onCreate(savedInstanceState)

        verticalLayout {
            padding = dip(5)
            val mTextView = textView {
                textSize = 12f
            }.layoutParams(width = matchParent, height = dip(300))
            button("Retrieve Weather") {
                textSize = 14f
                onClick {
                    // Declare a background asynchronous task, no need for an AsyncTask anymore
                    async {
                        // Heavy duty work made on the background
                        val networkClient = NetworkClient()
                        val stream = BufferedInputStream(
                                networkClient.get("https://raw.githubusercontent.com/irontec/android-kotlin-samples/master/common-data/bilbao.json"))
                        val bufferedReader = BufferedReader(InputStreamReader(stream));
                        val stringBuilder = StringBuilder();
                        bufferedReader.forEachLine { stringBuilder.append(it) }
                        val gsonBuilder = GsonBuilder().serializeNulls();
                        gsonBuilder.registerTypeAdapter(javaClass<WeatherObject>(), WeatherDeserializer());
                        val gson = gsonBuilder.create();
                        val weather = gson.fromJson(stringBuilder.toString(), javaClass<WeatherObject>()) as WeatherObject

                        uiThread {
                            // Just set the TextView text on the UI-Thread
                            mTextView.setText(weather.toString())
                        }
                    }
                }
            }.layoutParams(width = matchParent, height = wrapContent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        getMenuInflater().inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()
        if (id == R.id.action_settings) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
