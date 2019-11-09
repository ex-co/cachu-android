package com.ex.cachu.login

import android.content.Context
import com.ex.cachu.CachuApplication
import com.kakao.auth.*

class KakaoSDKAdapter : KakaoAdapter() {

    override fun getApplicationConfig(): IApplicationConfig {
        return object: IApplicationConfig {
            override fun getApplicationContext(): Context {
                return CachuApplication.applicationContext()
            }
        }
    }

    override fun getSessionConfig(): ISessionConfig {
        return object: ISessionConfig {
            override fun isSaveFormData(): Boolean {
                return true
            }

            override fun getAuthTypes(): Array<AuthType> {
                return arrayOf(AuthType.KAKAO_TALK_ONLY)
            }

            override fun isSecureMode(): Boolean {
                return false
            }

            override fun getApprovalType(): ApprovalType? {
                return ApprovalType.INDIVIDUAL
            }

            override fun isUsingWebviewTimer(): Boolean {
                return false
            }
        }
    }
}