package com.ex.cachu.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ex.cachu.R
import com.ex.cachu.ui.HomeActivity
import com.kakao.auth.ISessionCallback
import com.kakao.auth.Session
import com.kakao.util.exception.KakaoException

class LoginActivity : AppCompatActivity(), ISessionCallback {

    companion object {
        private const val TAG: String = "LoginActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_layout)

        Session.getCurrentSession().addCallback(this)
        Session.getCurrentSession().checkAndImplicitOpen()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.d(TAG, "onActivityResult " + requestCode + ", " + resultCode)

        if (Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)) {
            return
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onDestroy() {
        super.onDestroy()
        Session.getCurrentSession().removeCallback(this)
    }

    fun redirectHomeActivity() {
        Log.d("LOGIN", "redirectMainAcitivty")
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    override fun onSessionOpenFailed(exception: KakaoException?) {
        Log.e(TAG, "onSessionOpenFailed")
    }

    override fun onSessionOpened() {
        Log.e(TAG, "onSEssionOpened")
        redirectHomeActivity()
    }

}
