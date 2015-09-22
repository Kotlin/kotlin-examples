package org.jetbrains.kotlin.gradle.androidsample

import android.content.Intent
import android.os.Bundle
import android.app.Activity
import android.view.Menu
import android.view.View
import android.widget.Button
import org.jetbrains.kotlin.gradle.androidsample.R

open class MainActivity2 : Activity() {

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var next: Button = findViewById(R.id.Button02) as Button
        next.setOnClickListener {  finish()  }
    }

    public override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.main_activity2, menu)
        return true
    }
}
