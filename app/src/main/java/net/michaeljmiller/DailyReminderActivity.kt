package net.michaeljmiller

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_daily_reminder.*
import kotlinx.android.synthetic.main.content_daily_reminder.*
import net.michaeljmiller.R.styleable.Toolbar

class DailyReminderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_reminder)
        setSupportActionBar(toolbar)

        val reference = getIntent().getStringExtra("reference")
        val reminder = getIntent().getStringExtra("reminder")

        toolbar.title = reference
        setSupportActionBar(toolbar)
        textView.text = reminder
    }

}
