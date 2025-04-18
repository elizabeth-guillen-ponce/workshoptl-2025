package com.example.workshop_tl.data.profile

import com.example.workshop_tl.domain.common.model.User
import kotlinx.coroutines.flow.Flow

interface ProfileSourceData {
    suspend fun getUserProfile(userId: String):  Flow<User?>
    suspend fun completeProfile(
        userId: String,
        name: String,
        lastName: String,
        gender: String,
        income: Double
    ): User
}
