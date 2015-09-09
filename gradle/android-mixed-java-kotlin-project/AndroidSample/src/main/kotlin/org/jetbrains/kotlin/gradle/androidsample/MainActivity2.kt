package org.jetbrains.kotlin.gradle.androidsample

import android.content.Intent
import android.os.Bundle
import android.app.Activity
import android.view.Menu
import android.widget.Button

open class MainActivity2 : Activity() {

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var next = findViewById(R.id.Button02) as Button
        next.setOnClickListener {
            val intent: Intent = Intent()
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    public override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main_activity2, menu)
        return true
    }
}
