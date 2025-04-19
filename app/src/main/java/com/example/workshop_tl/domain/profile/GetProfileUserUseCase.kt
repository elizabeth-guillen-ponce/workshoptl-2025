package com.example.workshop_tl.domain.profile

import com.example.workshop_tl.data.profile.ProfileSourceData
import com.example.workshop_tl.domain.common.model.User
import com.example.workshop_tl.domain.common.model.UserType
import com.example.workshop_tl.domain.remoteconfig.SetDefaultValuesRemoteUseCase
import com.example.workshop_tl.utils.RemoteConfig
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class GetProfileUserUseCase(
    private val profileSourceData: ProfileSourceData
) {
    suspend operator fun invoke(userId: String): Flow<User?> {
        val user = profileSourceData.getUserProfile(userId)
        return user
    }
}