package com.example.workshop_tl.data.profile

import android.util.Log
import com.example.workshop_tl.domain.common.model.User
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.dataObjects
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.tasks.await

class ProfileSourceDataImpl(private val firestore: FirebaseFirestore) : ProfileSourceData {

    override suspend fun getUserProfile(userId: String): Flow<User?> {
        Log.d("ProfileSourceDataImpl", "getUserProfile: $userId")
        val user = firestore.collection(USERS_COLLECTION).document(userId).dataObjects<User>()
        return user
    }

    override suspend fun completeProfile(
        userId: String,
        name: String,
        lastName: String,
        gender: String,
        income: Double
    ): User {
        val user = User(userId, name, lastName, gender, income)
        firestore.collection(USERS_COLLECTION).document(userId)
            .set(user).await()
        return user
    }

    companion object {
        private const val USER_ID_FIELD = "userId"
        private const val USERS_COLLECTION = "users"
    }
}