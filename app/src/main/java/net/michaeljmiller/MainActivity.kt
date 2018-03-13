package net.michaeljmiller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val values = arrayOf(
                "Food",
                "Messages",
                "Resume"
        )

        val listView = findViewById<ListView>(R.id.main_list_view)

        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values)

        listView.adapter = adapter
    }
}
