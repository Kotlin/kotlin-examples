package com.irontec.kotlintest

import android.os.AsyncTask
import android.support.v7.app.ActionBarActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.irontec.kotlintest.networking.NetworkClient
import org.json.JSONObject
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


public class MainActivity : ActionBarActivity() {

    open val mTextView: TextView
        get() {
            return findViewById(R.id.text) as TextView
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GetJsonWithOkHttpClient(mTextView).execute()

    }

    open class GetJsonWithOkHttpClient(textView: TextView) : AsyncTask<Void, Void, String>() {

        val mInnerTextView = textView

        override fun doInBackground(vararg params: Void?): String? {
            val networkClient = NetworkClient()
            val stream = BufferedInputStream(
                    networkClient.get("https://raw.githubusercontent.com/irontec/android-kotlin-samples/master/common-data/bilbao.json"))
            return readStream(stream);
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            mInnerTextView.setText(result)

        }

        fun readStream(inputStream: BufferedInputStream): String {
            val bufferedReader = BufferedReader(InputStreamReader(inputStream));
            val stringBuilder = StringBuilder();
            bufferedReader.forEachLine { stringBuilder.append(it) }
            return stringBuilder.toString()
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
