package com.example.workshop_tl.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {

    private val _showSignUp = MutableLiveData<Boolean>()
    val showSignUp: LiveData<Boolean> = _showSignUp

    fun navToScreen(authScreens: AuthScreens) {
        when (authScreens) {
            AuthScreens.LOGIN -> {}
            AuthScreens.SIGN_UP -> _showSignUp.value = true
            AuthScreens.FORGOT_PASSWORD -> {}
            AuthScreens.KYC -> {}
            else -> {}
        }
    }

}
