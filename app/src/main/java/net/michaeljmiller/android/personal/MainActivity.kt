package net.michaeljmiller.android.personal

import net.michaeljmiller.android.personal.lib.service.DailyReminderService
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.StrictMode
import android.os.Bundle


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupThreadPolicy()
        setupView()
    }

    private fun setupThreadPolicy() {
        val policy =
            StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
    }

    private fun setupView() {
        setContentView(R.layout.activity_main)
        bindReminderToView()
    }

    private fun bindReminderToView() {
        val textViewReference = findViewById(R.id.reference) as TextView
        val textViewReminder = findViewById(R.id.reminder) as TextView

        val reminder = DailyReminderService(applicationContext).get()

        if (reminder != null) {
            textViewReference.text = reminder.reference
            textViewReminder.text = reminder.reminder
        }
    }
}
