package net.michaeljmiller

import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.tasks.Task
import android.content.Intent
import android.os.Bundle
import java.util.*

class AuthenticationActivity : AppCompatActivity() {

    private var mGoogleSignInClient: GoogleSignInClient? = null
    private val RC_SIGN_IN: Int = 9001
    private val currentActivity: AppCompatActivity = this;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        Timer().schedule(object : TimerTask() {
            override fun run() {
                val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestEmail()
                        .build()
                mGoogleSignInClient = GoogleSignIn.getClient(currentActivity, gso);
                val signInIntent = mGoogleSignInClient!!.getSignInIntent()
                startActivityForResult(signInIntent, RC_SIGN_IN)
            }
        }, 3500)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode === RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) = try {
        val account = completedTask.getResult(ApiException::class.java)
        if(account.email.toString() == "commnerd@gmail.com" || account.email.toString() == "waterchica@gmail.com") {
            val mainActivityIntent = Intent(currentActivity, MainActivity::class.java)
            currentActivity.runOnUiThread({ startActivity(mainActivityIntent) })
        }
        else {
            currentActivity.runOnUiThread({ onBackPressed() })
        }
    } catch (e: ApiException) {
        currentActivity.runOnUiThread({ onBackPressed() })
    }
}
