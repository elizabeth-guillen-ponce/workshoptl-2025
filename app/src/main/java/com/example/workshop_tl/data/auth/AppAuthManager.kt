package com.example.workshop_tl.data.auth

import com.google.firebase.auth.FirebaseUser

interface AppAuthManager {

    suspend fun getCurrentUser(): FirebaseUser?
    suspend fun signIn(email: String, password: String): FirebaseUser?
    suspend fun signOut()
    suspend fun signUp(email: String, password: String): FirebaseUser?
}