package com.example.workshop_tl.presentation

import com.example.workshop_tl.domain.analytics.SetUserIdAnalyticsUseCase
import com.example.workshop_tl.domain.analytics.TrackEventUseCase
import com.example.workshop_tl.domain.auth.LoginUseCase
import com.example.workshop_tl.domain.auth.SignUpUseCase
import com.example.workshop_tl.domain.cloudmessage.GetFirebaseTokenUseCase
import com.example.workshop_tl.domain.remoteconfig.StartRemoteConfigUseCase
import com.example.workshop_tl.presentation.common.BaseViewModel

class AuthViewModel constructor(
    private val signUpUseCase: SignUpUseCase,
    private val loginUseCase: LoginUseCase,
    private val trackEventUseCase: TrackEventUseCase,
    private val setUserIdUseCase: SetUserIdAnalyticsUseCase,
    private val getFirebaseTokenUseCase: GetFirebaseTokenUseCase,
    private val startRemoteConfigUseCase: StartRemoteConfigUseCase
) : BaseViewModel() {

    init {
        launchCatching {
            startRemoteConfigUseCase()
            getFirebaseTokenUseCase()
        }
    }

    fun onSignUpClicked(email: String, confirmEmail: String, password: String) {
        launchCatching {
            signUpUseCase(email, confirmEmail, password)
            setUserId(email)
            trackEvent("sign_up")
            navToScreen(Screens.KYC)
        }
    }

    fun onLoginClicked(email: String, password: String) {
        launchCatching {
            loginUseCase(email, password)
            setUserId(email)
            trackEvent("login")
            navToScreen(Screens.DASHBOARD)
        }
    }

    fun trackEvent(eventName: String, params: Map<String, Any>? = null) {
        trackEventUseCase(eventName, params)
    }

    fun setUserId(email: String) {
        setUserIdUseCase(email)
    }
}
