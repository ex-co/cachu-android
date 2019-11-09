package com.ex.cachu

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kakao.auth.ISessionCallback
import com.kakao.auth.Session
import com.kakao.util.exception.KakaoException

class LoginActivity : AppCompatActivity() {

    private var callback : SessionCallback? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_layout)

        callback = SessionCallback()
        Session.getCurrentSession().addCallback(callback)
        //Session.getCurrentSession().checkAndImplicitOpen()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.e("LOGIN", "TT")
        super.onActivityResult(requestCode, resultCode, data)
    }

    private class SessionCallback : ISessionCallback {

        override fun onSessionOpenFailed(exception: KakaoException?) {
            Log.e("LOGIN", "FAILED")
        }

        override fun onSessionOpened() {
            Log.e("LOGIN", "Hello WOrdl")
            LoginActivity().redirectMainActivity()
        }
    }


    fun redirectMainActivity() {
        Log.e("LOGIN", "redirect")
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
