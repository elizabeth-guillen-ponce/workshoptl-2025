package com.example.workshop_tl.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workshop_tl.domain.auth.LoginUseCase
import com.example.workshop_tl.domain.auth.SignUpUseCase
import com.example.workshop_tl.presentation.common.BaseViewModel
import kotlinx.coroutines.launch

class AuthViewModel constructor(
    private val signUpUseCase: SignUpUseCase,
    private val loginUseCase: LoginUseCase
) : BaseViewModel() {

    private val _navToScreen = MutableLiveData<AuthScreens>()
    val navToScreen: LiveData<AuthScreens> = _navToScreen

    init {

    }

    fun onSignUpClicked(email: String, confirmEmail: String, password: String) {
        launchCatching {
            signUpUseCase(email, confirmEmail, password)
            navToScreen(AuthScreens.LOGIN_SUCCESS)
        }
        navToScreen(AuthScreens.KYC)
    }

    fun onLoginClicked(email: String, password: String) {
        launchCatching {
            loginUseCase(email, password)
            navToScreen(AuthScreens.LOGIN_SUCCESS)
        }
        navToScreen(AuthScreens.KYC)
    }

    fun navToScreen(authScreens: AuthScreens) {
        _navToScreen.value = authScreens
    }
}
