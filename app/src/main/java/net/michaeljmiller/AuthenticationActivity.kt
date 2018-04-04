package net.michaeljmiller

import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import net.michaeljmiller.bundles.api.utils.AuthenticationManager
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import net.michaeljmiller.bundles.api.ApiActivity
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.tasks.Task
import android.content.Intent
import org.json.JSONObject
import android.os.Bundle
import android.util.Log
import java.util.*

class AuthenticationActivity<ApiClient> : ApiActivity() {
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
                        .requestIdToken(getString(R.string.google_oauth_client_id))
                        .build()
                mGoogleSignInClient = GoogleSignIn.getClient(currentActivity, gso);
                val signInIntent = mGoogleSignInClient!!.getSignInIntent()
                startActivityForResult(signInIntent, RC_SIGN_IN)
            }
        }, 1)
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
            AuthenticationManager.login(this, account.idToken.toString());
        }
        else {
            exitApp()
        }
    } catch (e: ApiException) {
        exitApp()
    }

    override fun handleResult(result: JSONObject) {
        Log.e("BLAH BLAH BLAH", "EXECUTING!!!")
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun exitApp() {
        this.runOnUiThread({ this.finish() })
    }
}
