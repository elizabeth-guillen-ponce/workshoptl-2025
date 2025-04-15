package com.example.workshop_tl.domain.session

import com.example.workshop_tl.data.session.SessionRemoteSource
import com.google.firebase.auth.FirebaseUser

class GetCurrentUserUseCase(private val sessionRemoteSource: SessionRemoteSource) {

    suspend operator fun invoke(): FirebaseUser {
        var user = sessionRemoteSource.getCurrentUser()
        if (user == null) throw Exception("User not logged in")
        return user
    }
}