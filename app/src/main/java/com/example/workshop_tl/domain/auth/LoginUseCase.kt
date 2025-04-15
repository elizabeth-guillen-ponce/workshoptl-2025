package com.example.workshop_tl.domain.auth

import com.example.workshop_tl.data.auth.AppAuthManager
import com.example.workshop_tl.presentation.common.isValidEmail

class LoginUseCase(private val authManager: AppAuthManager) {

    suspend operator fun invoke(email: String, password: String): Boolean {
        if (!email.isValidEmail() || password.isEmpty()) throw IllegalArgumentException("Email and password cannot be empty")
        val success = authManager.signIn(email, password)
        if (success == null || !success) throw Exception("Sign in failed")
        return success
    }
}