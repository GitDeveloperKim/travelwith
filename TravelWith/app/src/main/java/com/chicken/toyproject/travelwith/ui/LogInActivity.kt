package com.chicken.toyproject.travelwith.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.chicken.toyproject.travelwith.R
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import kotlinx.android.synthetic.main.login.*
import org.jetbrains.anko.toast


class LogInActivity : AppCompatActivity() {

    companion object {
        const val TAG: String = "LogInActivity"
        const val REQUEST_GOOGLE_SIGN_IN: Int = 100
    }

    lateinit var googleSigneInClient: GoogleSignInClient
    lateinit var callbackManager: CallbackManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        // Configure Google Sign In
        // GoogleSignInOptions : include API key value and request value.
        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        googleSigneInClient = GoogleSignIn.getClient(this, googleSignInOptions)
        btn_sign_in.setOnClickListener {
            signIn()
        }


        callbackManager = CallbackManager.Factory.create()
        login_button.setReadPermissions("email")
        // Callback registration
        login_button.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {
                // App code
            }

            override fun onCancel() {
                // App code
            }

            override fun onError(exception: FacebookException) {
                // App code
            }
        })
        LoginManager.getInstance().registerCallback(callbackManager,
            object : FacebookCallback<LoginResult> {
                override fun onSuccess(loginResult: LoginResult) {
                    // App code
                }

                override fun onCancel() {
                    // App code
                }

                override fun onError(exception: FacebookException) {
                    // App code
                }
            })
    }

    private fun signIn() {
        val signInIntent = googleSigneInClient.signInIntent
        startActivityForResult(signInIntent, REQUEST_GOOGLE_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d(TAG, "onActivityResult")
        if (requestCode == REQUEST_GOOGLE_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            Log.d(TAG, "onActivityResult : " + task.isCanceled)
            Log.d(TAG, "onActivityResult : " + task.isComplete)
            Log.d(TAG, "onActivityResult : " + task.isSuccessful)
            handleSignInResult(task)
        } else {
            callbackManager.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            val debugInfo =
                "Email : " + account?.email + "displayName : " + account?.displayName + "familyName : " + account?.familyName +
                        "givenName : " + account?.givenName + "idToken : " + account?.idToken + "id : " + account?.id
            Log.d(TAG, debugInfo)
            toast(debugInfo)
        } catch (e: ApiException) {
            toast("error: ${e.statusCode}. ")
            //TODO: HERE IS WHERE I CAN SEE THE ERROR (10)
            //TODO: need to make our google public id
            // https://developers.google.com/identity/sign-in/android/start-integrating
        }
    }
}
