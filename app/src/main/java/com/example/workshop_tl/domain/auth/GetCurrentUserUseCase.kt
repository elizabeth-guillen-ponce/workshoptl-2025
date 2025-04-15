package com.example.workshop_tl.domain.auth

import com.example.workshop_tl.data.auth.AppAuthManager
import com.google.firebase.auth.FirebaseUser

class GetCurrentUserUseCase(private val authManager: AppAuthManager) {

    suspend operator fun invoke(): FirebaseUser {
        var user = authManager.getCurrentUser()
        if (user == null) throw Exception("User not logged in")
        return user
    }
}
