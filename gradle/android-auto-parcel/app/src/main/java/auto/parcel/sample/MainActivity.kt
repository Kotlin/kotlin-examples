package auto.parcel.sample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        click_me.setOnClickListener {
            val detailIntent = Intent(this, DetailActivity::class.java)
            detailIntent.putExtra("Person", SampleData.BOB)
            startActivity(detailIntent)
        }
    }
}
