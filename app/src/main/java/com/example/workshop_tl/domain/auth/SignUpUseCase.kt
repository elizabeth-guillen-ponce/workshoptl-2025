package com.example.workshop_tl.domain.auth

import com.example.workshop_tl.data.auth.AppAuthManager
import com.example.workshop_tl.presentation.common.isSameEmail
import com.example.workshop_tl.presentation.common.isValidEmail
import com.example.workshop_tl.presentation.common.isValidPassword
import com.google.firebase.auth.FirebaseUser

class SignUpUseCase(private val authManager: AppAuthManager) {

    suspend operator fun invoke(
        email: String,
        confirmEmail: String,
        password: String
    ): FirebaseUser? {
        if (!email.isValidEmail() || !email.isSameEmail(confirmEmail) || !password.isValidPassword()) {
            throw IllegalArgumentException("Email and password cannot be empty")
        }
        val user = authManager.signUp(email, password)
        if (user == null) throw Exception("Sign up failed")
        return user
    }
}
