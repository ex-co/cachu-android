package com.ex.cachu.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ex.cachu.R
import com.ex.cachu.login.LoginActivity
import com.kakao.auth.ISessionCallback
import com.kakao.auth.Session
import com.kakao.util.exception.KakaoException

class SplashActivity : AppCompatActivity() {

    private val TAG: String = "SplashActivity"
    private val SPLASH_TIME_OUT: Long = 3000 // 3 sec

    private var callback: ISessionCallback? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        callback = object: ISessionCallback {
            override fun onSessionOpened() {
                Log.d(TAG, "onSessionOpened")
                goToHomeActivity()
            }

            override fun onSessionOpenFailed(exception: KakaoException?) {
                Log.d(TAG, "onSessionOpenFailed")
                goToLoginActivity()
            }
        }

        Handler().postDelayed({
            if (!Session.getCurrentSession().checkAndImplicitOpen()) {
                goToLoginActivity()
            }
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)
    }

    private fun goToHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun goToLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
