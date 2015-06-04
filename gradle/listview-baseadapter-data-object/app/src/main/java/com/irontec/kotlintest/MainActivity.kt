package com.irontec.kotlintest

import android.support.v7.app.ActionBarActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.widget.ListView
import com.irontec.kotlintest.adapters.CustomListAdapter
import com.irontec.kotlintest.models.CustomPojo


public class MainActivity : ActionBarActivity() {

    val mListView: ListView
        get() {
            return findViewById(R.id.list) as ListView
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listdata = Array<CustomPojo>(90, {i -> CustomPojo(name = i.toString())})

        val adapter = CustomListAdapter(data = listdata, context = this)

        mListView.setAdapter(adapter)
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

    fun getLastNumber(dataset: Array<Int>) : Int {
        return dataset.last();
    }
}
