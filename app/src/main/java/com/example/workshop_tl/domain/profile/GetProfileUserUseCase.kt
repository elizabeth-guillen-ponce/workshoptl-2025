package com.example.workshop_tl.domain.profile

import com.example.workshop_tl.data.profile.ProfileSourceData
import com.example.workshop_tl.domain.common.model.User
import com.example.workshop_tl.domain.common.model.UserType
import com.example.workshop_tl.domain.remoteconfig.SetDefaultValuesRemoteUseCase
import com.example.workshop_tl.utils.RemoteConfig
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class GetProfileUserUseCase(
    private val profileSourceData: ProfileSourceData,
    private val setDefaultValuesRemoteUseCase: SetDefaultValuesRemoteUseCase
) {
    suspend operator fun invoke(userId: String): Flow<User?> {
        val user = profileSourceData.getUserProfile(userId)
        val temp = user.first()
        setDefaultValuesRemoteUseCase(
            RemoteConfig.Keys.USER_TYPE,
            temp?.getTypeUser()?.name ?: UserType.SILVER.name
        )
        return user
    }
}