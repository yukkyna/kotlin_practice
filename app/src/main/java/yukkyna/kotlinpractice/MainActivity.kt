package yukkyna.kotlinpractice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.LoaderManager
import android.support.v4.content.Loader
import android.widget.ScrollView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        LoaderManager.getInstance(this@MainActivity).initLoader(1, Bundle(), callback)
    }

    private val callback : LoaderManager.LoaderCallbacks<SearchResult> = object : LoaderManager.LoaderCallbacks<SearchResult> {
        override fun onCreateLoader(p0: Int, p1: Bundle?): Loader<SearchResult> {
            return SearchImpl(this@MainActivity)
        }

        override fun onLoadFinished(p0: Loader<SearchResult>, p1: SearchResult?) {
            LoaderManager.getInstance(this@MainActivity).destroyLoader(p0.id)

            val resultView = findViewById<TextView>(R.id.search_result)
            resultView.text = p1.toString()
        }

        override fun onLoaderReset(p0: Loader<SearchResult>) {
        }
    }


}
