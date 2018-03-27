package net.michaeljmiller


import kotlinx.android.synthetic.main.activity_daily_reminder.*
import kotlinx.android.synthetic.main.content_daily_reminder.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle


class DailyReminderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_reminder)
        setSupportActionBar(toolbar)

        val reference = intent.getStringExtra("reference")
        val reminder = intent.getStringExtra("reminder")

        toolbar.title = reference
        setSupportActionBar(toolbar)
        textView.text = reminder
    }

}
