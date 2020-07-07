package net.michaeljmiller.android.personal

import android.os.Bundle
import android.os.StrictMode
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.michaeljmiller.android.personal.lib.service.DailyReminderService


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val policy =
            StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textViewReference = findViewById(R.id.reference) as TextView
        val textViewReminder = findViewById(R.id.reminder) as TextView

        val reminder = DailyReminderService().get()
        textViewReference.text = reminder.getReference()
        textViewReminder.text = reminder.getReminder()
    }
}
