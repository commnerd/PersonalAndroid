package net.michaeljmiller.bundles.api

import android.support.v7.app.AppCompatActivity
import android.support.design.widget.Snackbar
import net.michaeljmiller.R
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_show.*

class ShowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

}
