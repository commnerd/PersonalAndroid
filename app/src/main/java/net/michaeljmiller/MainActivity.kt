package net.michaeljmiller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import net.michaeljmiller.utils.DailyReminder


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val values = arrayOf(
                "Reminder",
                "Food"
                // "Messages",
                // "Resume"
        )

        val listView = findViewById<ListView>(R.id.main_list_view)

        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values)

        listView.adapter = adapter
        listView.setOnItemClickListener {
            _, view, _, _ -> navigate((view as TextView).text.toString())
        }
    }

    private fun navigate(dest: String) {
        when(dest) {
            "Reminder" -> DailyReminder(this).run()
            "Food" -> startActivity(Intent(this, net.michaeljmiller.FoodActivity::class.java))
        }
    }
}
