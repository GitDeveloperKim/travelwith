package com.chicken.toyproject.travelwith.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.chicken.toyproject.travelwith.R
import com.chicken.toyproject.travelwith.TravelWithApp
import com.chicken.toyproject.travelwith.core.network.RemoteGenerator
import com.chicken.toyproject.travelwith.core.network.RemoteService
import com.chicken.toyproject.travelwith.core.network.newRetrofit
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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

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

        initGoogleSignIn()
        initFaceBookSignIn()
    }

    private fun initGoogleSignIn() {
        // Configure Google Sign In
        // GoogleSignInOptions : include API key value and request value.
        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.web_client_id))
            .requestEmail()
            .build()

        btn_sign_in.setOnClickListener {
            requestGoogleSignIn()
        }
        googleSigneInClient = GoogleSignIn.getClient(this, googleSignInOptions)
    }

    private fun initFaceBookSignIn() {
        callbackManager = CallbackManager.Factory.create()
        login_button.setReadPermissions(Arrays.asList("email", "public_profile", "user_friends"))
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
                    val accessToken = loginResult.accessToken
                    val id = accessToken.applicationId
                    val token = accessToken.token
                    val isLoggedIn = accessToken != null && !accessToken.isExpired
                    Log.d(TAG, "FacebookCallback onSuccess : " + id)
                    Log.d(TAG, "FacebookCallback onSuccess : " + token)
                    Log.d(TAG, "FacebookCallback onSuccess : " + accessToken.userId)
                    //LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));

                    signInToServer(id.toString(), token.toString(), "facebook")
                }

                override fun onCancel() {
                    // App code
                }

                override fun onError(exception: FacebookException) {
                    // App code
                    Log.d(TAG, "FacebookCallback onError : " + exception.message)
                }
            })
    }

    private fun signInToServer(id: String, token: String, type: String) {
        //With Cookie??
        TravelWithApp.apiClient().logIn(id, token, type).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                //TODO: response.code is needed??  (ex: server error, success)
                when(response!!.code()) {
                    200 -> {
                        finish()
                        startActivity(Intent(this@LogInActivity, MainActivity::class.java))
                    }
                }
            }

            override fun onFailure(call: Call<Void>?, t: Throwable?) {

            }

        })

//        RemoteGenerator.getService().logIn(id, token, type).enqueue(object : Callback<Void> {
//            override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
//                //TODO: response.code is needed??  (ex: server error, success)
//                when(response!!.code()) {
//                    200 -> {
//                        finish()
//                        startActivity(Intent(this@LogInActivity, MainActivity::class.java))
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<Void>?, t: Throwable?) {
//
//            }
//
//        })
    }

    private fun requestGoogleSignIn() {
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
            val idToken = account!!.idToken
            val id = account.id
            // TODO(developer): send ID Token to server and validate
            val debugInfo =
                "Email : " + account.email + ", displayName : " + account.displayName + ", familyName : " + account.familyName +
                        ", givenName : " + account.givenName + ", idToken : " + idToken + ", id : " + id
            Log.d(TAG, debugInfo)

            signInToServer(id.toString(), idToken.toString(), "google")

        } catch (e: ApiException) {
            Log.w(TAG, "handleSignInResult:error", e)
            toast("error: ${e.statusCode}. ")
        }
    }

/*
    // For Developer hash key
    private fun getAppKeyHash() {
        try {
            val info =
                packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNATURES)
            for (signature in info.signatures) {
                var md: MessageDigest
                md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())

                val something = String(Base64.getEncoder().encode(md.digest()))//String(Base64.encode(md.digest(), 0))
                Log.d(TAG, "Hash key" + something)
            }
        } catch (e: Exception) {
            Log.e(TAG, "name not found" + e.toString())
        }

        try {
            val info =
                packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNATURES)
            for (signature in info.signatures) {
                val md =
                    MessageDigest.getInstance("SHA1")
                md.update(signature.toByteArray())
                val digest = md.digest()
                val toRet = StringBuilder()
                for (i in digest.indices) {
                    if (i != 0) toRet.append(":")
                    val b: Int = digest[i] and 0xff
                    val hex = Integer.toHexString(b)
                    if (hex.length == 1) toRet.append("0")
                    toRet.append(hex)
                }
                Log.d(TAG, "$key $toRet")
            }
        } catch (e: Exception) {
            Log.e(TAG, "name not found" + e.toString())
        }
    }
 */
}
