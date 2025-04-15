package com.example.workshop_tl.domain.auth

import com.example.workshop_tl.data.auth.AppAuthManager
import com.example.workshop_tl.presentation.common.isSameEmail
import com.example.workshop_tl.presentation.common.isValidEmail
import com.example.workshop_tl.presentation.common.isValidPassword

class SignUpUseCase(private val authManager: AppAuthManager) {

    suspend operator fun invoke(
        email: String,
        confirmEmail: String,
        password: String
    ): Boolean? {
        if (!email.isValidEmail() || !email.isSameEmail(confirmEmail) || !password.isValidPassword()) {
            throw IllegalArgumentException("Email and password cannot be empty")
        }
        val success = authManager.signUp(email, password)
        if (success == null || !success) throw Exception("Sign up failed")
        return success
    }
}
