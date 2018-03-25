package net.michaeljmiller

import android.support.v7.app.AppCompatActivity
import android.accounts.AccountManager
import android.os.Bundle

class AuthenticationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        val am = AccountManager.get(this)
        val accounts = am.getAccountsByType(AccountManager.KEY_AUTHTOKEN)
    }

}
