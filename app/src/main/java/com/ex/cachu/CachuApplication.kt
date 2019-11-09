package com.ex.cachu

import android.app.Application
import android.content.Context
import com.ex.cachu.login.KakaoSDKAdapter
import com.kakao.auth.KakaoSDK

class CachuApplication : Application() {

    lateinit var context: Context

    init {
        instance = this
    }

    companion object {
        private var instance: CachuApplication? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()

        KakaoSDK.init(KakaoSDKAdapter())
    }
}