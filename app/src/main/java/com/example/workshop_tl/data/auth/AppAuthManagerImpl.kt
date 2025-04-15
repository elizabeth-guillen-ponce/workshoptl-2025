package com.example.workshop_tl.data.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await

class AppAuthManagerImpl(private val auth: FirebaseAuth) : AppAuthManager {

    override suspend fun signIn(email: String, password: String): Boolean? {
        val tmpUser = auth.signInWithEmailAndPassword(email, password).await()
        return tmpUser.user != null
    }

    override suspend fun signOut(user: FirebaseUser?) {
        user?.let {
            if (!it.isAnonymous) {
                it.delete()
            }
        }
        auth.signOut()
    }

    override suspend fun signUp(email: String, password: String): Boolean? {
        val tmpUser = auth.createUserWithEmailAndPassword(email, password).await()
        return tmpUser.user != null
    }
}