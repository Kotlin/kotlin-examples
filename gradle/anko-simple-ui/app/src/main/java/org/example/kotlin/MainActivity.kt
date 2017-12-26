package org.example.kotlin

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.google.gson.GsonBuilder
import org.example.kotlin.deserializers.WeatherDeserializer
import org.example.kotlin.models.WeatherObject
import org.example.kotlin.networking.NetworkClient
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStreamReader


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            padding = dip(5)
            val mTextView = textView {
                textSize = 16f
                width = matchParent
                height = dip(300)
            }
            button("Retrieve Weather") {
                textSize = 14f
                width = matchParent
                height = wrapContent
                onClick {
                    GetJsonWithOkHttpClient(mTextView).execute()
                }
            }
        }

    }

    open class GetJsonWithOkHttpClient(textView: TextView) : AsyncTask<Unit, Unit, String>() {

        val mInnerTextView = textView

        override fun doInBackground(vararg params: Unit?): String? {
            val networkClient = NetworkClient()
            val stream = BufferedInputStream(
                    networkClient.get("https://raw.githubusercontent.com/JetBrains/kotlin-examples/master/common-data/bilbao.json"))
            return readStream(stream)
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)


            val gsonBuilder = GsonBuilder().serializeNulls().setPrettyPrinting()
            gsonBuilder.registerTypeAdapter(WeatherObject::class.java, WeatherDeserializer())
            val gson = gsonBuilder.create()
            val weather = gson.fromJson(result, WeatherObject::class.java)

            mInnerTextView.text = weather.toString()

        }

        private fun readStream(inputStream: BufferedInputStream): String {
            val bufferedReader = BufferedReader(InputStreamReader(inputStream))
            val stringBuilder = StringBuilder()
            bufferedReader.forEachLine { stringBuilder.append(it) }
            return stringBuilder.toString()
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
