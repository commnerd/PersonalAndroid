package net.michaeljmiller.android.personal

import net.michaeljmiller.android.personal.lib.service.DailyReminderService
import net.michaeljmiller.android.personal.lib.interfaces.Reminder
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
        val textViewReference = findViewById<TextView>(R.id.reference)
        val textViewReminder = findViewById<TextView>(R.id.reminder)

        val reminder = DailyReminderService(applicationContext).get() as Reminder

        textViewReference.text = reminder.getReference()
        textViewReminder.text = reminder.getReminder()
    }
}
