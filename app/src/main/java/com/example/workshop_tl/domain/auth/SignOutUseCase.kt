package com.example.workshop_tl.domain.auth

import com.example.workshop_tl.data.auth.AppAuthManager
import com.example.workshop_tl.data.session.SessionRemoteSource

class SignOutUseCase(
    private val authManager: AppAuthManager,
    private val sessionRemoteSource: SessionRemoteSource
) {

    suspend operator fun invoke() {
        authManager.signOut(sessionRemoteSource.getCurrentUser())
    }
}