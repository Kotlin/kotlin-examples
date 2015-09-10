package mobi.porquenao.poc.kotlin.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import mobi.porquenao.poc.kotlin.R
import kotlinx.android.synthetic.main.*

public class MainActivity : BaseActivity() {
    lateinit var listAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        with (list) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            listAdapter = MainAdapter()
            adapter = listAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        listAdapter.add()
        list.smoothScrollToPosition(0)
        return true
    }

}
