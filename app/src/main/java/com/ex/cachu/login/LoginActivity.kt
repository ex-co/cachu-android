package com.ex.cachu.login

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ex.cachu.R
import com.ex.cachu.ui.HomeActivity
import com.kakao.auth.ISessionCallback
import com.kakao.auth.Session
import com.kakao.network.ErrorResult
import com.kakao.usermgmt.UserManagement
import com.kakao.usermgmt.callback.MeV2ResponseCallback
import com.kakao.usermgmt.response.MeV2Response
import com.kakao.util.exception.KakaoException

class LoginActivity : AppCompatActivity() {

    companion object {
        private const val TAG: String = "LoginActivity"
    }

    private val callback = object: ISessionCallback {

        override fun onSessionOpenFailed(exception: KakaoException?) {
            Log.d(TAG, "onSessionOpenFailed")
        }

        override fun onSessionOpened() {
            Log.d(TAG, "onSessionOpened")
            requestMyInfo()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_layout)

        Session.getCurrentSession().addCallback(callback)
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
        Session.getCurrentSession().removeCallback(callback)
    }

    private fun redirectHomeActivity(userNickname: String, imageUrl: String?) {
        val intent = Intent(this, HomeActivity::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("nickname", userNickname)
        intent.putExtra("imageUrl", imageUrl)
        startActivity(intent)
    }

    private fun requestMyInfo() {
        val keys = ArrayList<String>()
        keys.add("properties.nickname")
        keys.add("properties.profile_image")

        UserManagement.getInstance().me(object: MeV2ResponseCallback() {

            override fun onSuccess(result: MeV2Response?) {
                if (result != null) {
                    var nickname = result.kakaoAccount.profile.nickname
                    var profileImageUrl = result.kakaoAccount.profile.profileImageUrl

                    redirectHomeActivity(nickname, profileImageUrl)
                }
            }

            override fun onFailure(errorResult: ErrorResult?) {
                Log.e(TAG, "onFailure")
                super.onFailure(errorResult)
            }

            override fun onSessionClosed(errorResult: ErrorResult?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }
}
