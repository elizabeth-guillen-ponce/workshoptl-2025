package com.example.workshop_tl.data.session

import com.google.firebase.auth.FirebaseUser

interface SessionRemoteSource {
    suspend fun getCurrentUser(): FirebaseUser?
}