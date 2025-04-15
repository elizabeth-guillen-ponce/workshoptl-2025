package com.example.workshop_tl.presentation

import com.example.workshop_tl.domain.auth.LoginUseCase
import com.example.workshop_tl.domain.auth.SignUpUseCase
import com.example.workshop_tl.presentation.common.BaseViewModel

class AuthViewModel constructor(
    private val signUpUseCase: SignUpUseCase,
    private val loginUseCase: LoginUseCase
) : BaseViewModel() {

    fun onSignUpClicked(email: String, confirmEmail: String, password: String) {
        launchCatching {
            signUpUseCase(email, confirmEmail, password)
            navToScreen(Screens.KYC)
        }
    }

    fun onLoginClicked(email: String, password: String) {
        launchCatching {
            loginUseCase(email, password)
            navToScreen(Screens.DASHBOARD)
        }
    }
}
