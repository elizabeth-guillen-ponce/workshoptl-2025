package com.example.workshop_tl.data.auth

import com.google.firebase.auth.FirebaseUser

interface AppAuthManager {
    suspend fun signIn(email: String, password: String): Boolean?
    suspend fun signOut(user: FirebaseUser?)
    suspend fun signUp(email: String, password: String): Boolean?
}