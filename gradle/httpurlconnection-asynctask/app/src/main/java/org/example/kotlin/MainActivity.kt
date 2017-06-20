package org.example.kotlin

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GetWeatherTask(this.text).execute()
    }

    class GetWeatherTask(textView: TextView) : AsyncTask<Unit, Unit, String>() {

        val innerTextView: TextView? = textView

        override fun doInBackground(vararg params: Unit?): String? {
            val url = URL("https://raw.githubusercontent.com/JetBrains/kotlin-examples/master/common-data/bilbao.json")
            val httpClient = url.openConnection() as HttpURLConnection
            if (httpClient.responseCode == HttpURLConnection.HTTP_OK) {
                try {
                    val stream = BufferedInputStream(httpClient.inputStream)
                    val data: String = readStream(inputStream = stream)
                    return data
                } catch (e: Exception) {
                    e.printStackTrace()
                } finally {
                    httpClient.disconnect()
                }
            } else {
                println("ERROR ${httpClient.responseCode}")
            }
            return null
        }

        fun readStream(inputStream: BufferedInputStream): String {
            val bufferedReader = BufferedReader(InputStreamReader(inputStream))
            val stringBuilder = StringBuilder()
            bufferedReader.forEachLine { stringBuilder.append(it) }
            return stringBuilder.toString()
        }

        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            innerTextView?.text = JSONObject(result).toString()

            /**
             * ... Work with the weather data
             */

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_settings) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
