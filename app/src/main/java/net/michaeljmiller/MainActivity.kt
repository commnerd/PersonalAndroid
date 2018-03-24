package net.michaeljmiller

import android.app.NotificationChannel
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import net.michaeljmiller.notifications.NotificationHelper


class MainActivity : AppCompatActivity() {

    private var noti: NotificationHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.noti = NotificationHelper(this)
        setContentView(R.layout.activity_main)

        val values = arrayOf(
                "Food"
                // "Messages",
                // "Resume"
        )

        val listView = findViewById<ListView>(R.id.main_list_view)

        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values)

        listView.adapter = adapter
        listView.setOnItemClickListener {
            // _, view, _, _ -> navigate((view as TextView).text.toString())
            _, _, _, _ -> message()
        }
    }

    private fun navigate(dest: String) {
        when(dest) {
            "Food" -> startActivity(Intent(this, net.michaeljmiller.FoodActivity::class.java))
        }
    }

    private fun message() {
        var notification = noti!!.buildNotification("test", "This is a test notification")
        noti!!.notify(notification);

    }
}
