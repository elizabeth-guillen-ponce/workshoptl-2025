package com.example.workshop_tl.domain.auth

import com.example.workshop_tl.data.auth.AppAuthManager

class SignOutUseCase(private val authManager: AppAuthManager) {

    suspend operator fun invoke() {
        authManager.signOut()
    }
}