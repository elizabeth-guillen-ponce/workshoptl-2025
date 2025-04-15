package com.example.workshop_tl.data.session

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SessionRemoteSourceImpl(private val auth: FirebaseAuth) : SessionRemoteSource {
    var currentUser: FirebaseUser? = null

    override suspend fun getCurrentUser(): FirebaseUser? {
        val tempUser = auth.currentUser
        if (tempUser != null) {
            currentUser = tempUser
        }
        return currentUser
    }
}