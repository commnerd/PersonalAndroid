package net.michaeljmiller

import android.support.v7.app.AppCompatActivity
import android.accounts.AccountManager
import android.content.Intent
import android.os.Bundle
import java.util.*



class AuthenticationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        /*
        val am = AccountManager.get(this)
        val accounts = am.getAccountsByType(AccountManager.KEY_AUTHTOKEN)
        */

        val currentActivity = this

        Timer().schedule(object : TimerTask() {
            override fun run() {
                currentActivity.runOnUiThread({ startActivity(Intent(currentActivity, MainActivity::class.java)) })
            }
        }, 3500)
    }

}
