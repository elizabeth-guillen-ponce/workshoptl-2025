package com.example.workshop_tl.data.profile

import com.example.workshop_tl.domain.common.model.User
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.dataObjects
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.tasks.await

class ProfileSourceDataImpl(private val firestore: FirebaseFirestore) : ProfileSourceData {

    override suspend fun getUserProfile(userId: String): Flow<List<User>> {
        val user =
            firestore.collection(USERS_COLLECTION).whereEqualTo(USER_ID_FIELD, userId)
                .dataObjects<User>()
        return user
    }

    override suspend fun completeProfile(
        userId: String,
        name: String,
        lastName: String,
        gender: String
    ): String {
        var item =
            firestore.collection(USERS_COLLECTION).add(User(userId, name, lastName, gender)).await()
        return item.id
    }

    companion object {
        private const val USER_ID_FIELD = "userId"
        private const val USERS_COLLECTION = "users"
    }
}