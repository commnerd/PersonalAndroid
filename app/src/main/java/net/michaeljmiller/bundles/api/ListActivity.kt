package net.michaeljmiller.bundles.api

import android.support.v7.app.AppCompatActivity
import android.support.design.widget.Snackbar
import net.michaeljmiller.R
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_list.*
import net.michaeljmiller.bundles.api.interfaces.ApiModel

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        setSupportActionBar(toolbar)

        val classType = (intent as ApiIntent<ApiModel>).getClassType()

        fab.setOnClickListener { view ->
            Snackbar.make(view, classType.canonicalName, Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

}
