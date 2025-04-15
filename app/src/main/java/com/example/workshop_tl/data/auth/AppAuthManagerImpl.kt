package com.example.workshop_tl.data.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await

class AppAuthManagerImpl(private val auth: FirebaseAuth) : AppAuthManager {

    var currentUser: FirebaseUser? = null

    override suspend fun getCurrentUser(): FirebaseUser? {
        currentUser = auth.currentUser
        return currentUser
    }

    override suspend fun signIn(email: String, password: String): FirebaseUser? {
        val tmpUser = auth.signInWithEmailAndPassword(email, password).await()
        if (tmpUser.user != null) {
            currentUser = tmpUser.user
        }
        return currentUser
    }

    override suspend fun signOut() {
        auth.currentUser?.let { user ->
            if (!user.isAnonymous) {
                user.delete()
            }
        }
        auth.signOut()
    }

    override suspend fun signUp(email: String, password: String): FirebaseUser? {
        val tmpUser = auth.createUserWithEmailAndPassword(email, password).await()
        if (tmpUser.user != null) {
            currentUser = tmpUser.user
        }
        return currentUser
    }
}