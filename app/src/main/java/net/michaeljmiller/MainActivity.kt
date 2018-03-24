package net.michaeljmiller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import net.michaeljmiller.notifications.NotificationHelper
import okhttp3.*
import java.io.IOException
import org.json.JSONObject
import android.app.PendingIntent






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
        // avoid creating several instances, should be singleon
        val client = OkHttpClient()

        val request = Request.Builder()
                .url("https://michaeljmiller.net/api/daily_reminder")
                .build()

        val context = this

        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace();
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val notifyIntent = Intent(context, DailyReminderActivity::class.java)
                    val json = JSONObject(response.body()!!.string())
                    val reference = json.getString("reference")
                    val reminder = json.getString("reminder")

                    notifyIntent.putExtra("reference", reference)
                    notifyIntent.putExtra("reminder", reminder)

                    // Set the Activity to start in a new, empty task
                    notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)

                    // Create the PendingIntent
                    val notifyPendingIntent = PendingIntent.getActivity(
                            context, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT
                    )

                    var notification = noti!!.buildNotification(reference, reminder)
                    notification.setContentIntent(notifyPendingIntent)
                    noti!!.notify(notification)
                }
            }
        })
    }
}
