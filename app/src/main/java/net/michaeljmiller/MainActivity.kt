package net.michaeljmiller

import android.app.ListActivity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import net.michaeljmiller.utils.DailyReminder


class MainActivity : AppCompatActivity() {

    private var listView: ListView? = null

    private var token: String? = null;

    private var adapter: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var values = arrayOf(
                "Reminder",
                "User",
                "Food"
        )

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, values.toMutableList())

        listView = findViewById(R.id.main_list_view) as ListView

        token = intent.getStringExtra("token")

        listView!!.adapter = adapter
        listView!!.setOnItemClickListener {
            _, view, position, _ -> navigate(position, view as TextView)
        }
    }

    private fun navigate(position: Int, view: TextView) {
        var dest = view.text.toString()
        when(dest) {
            "Reminder" -> DailyReminder(this).run()
            "Food" -> startActivity(Intent(this, ListActivity::class.java))
        }
    }

    private fun showUser() {
        val dailyReminderIntent = Intent(this, DailyReminderActivity::class.java)
        dailyReminderIntent.putExtra("reference", intent.getStringExtra("email"))
        dailyReminderIntent.putExtra("reminder", intent.getStringExtra("token"))
        startActivity(dailyReminderIntent)
    }
}
