package com.example.workshop_tl.domain.auth

import com.example.workshop_tl.data.auth.AppAuthManager
import com.example.workshop_tl.presentation.common.isValidEmail
import com.google.firebase.auth.FirebaseUser

class LoginUseCase(private val authManager: AppAuthManager) {

    suspend operator fun invoke(email: String, password: String): FirebaseUser {
        if (!email.isValidEmail() || password.isEmpty()) throw IllegalArgumentException("Email and password cannot be empty")
        val user = authManager.signIn(email, password)
        if (user == null) throw Exception("Sign in failed")
        return user
    }
}