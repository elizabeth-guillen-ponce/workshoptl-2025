package com.example.workshop_tl.domain.profile

import com.example.workshop_tl.data.profile.ProfileSourceData
import com.example.workshop_tl.domain.remoteconfig.SetDefaultValuesRemoteUseCase
import com.example.workshop_tl.domain.session.GetUserIdUseCase
import com.example.workshop_tl.utils.RemoteConfig

class CreateProfileUserUseCase(
    private val profileSourceData: ProfileSourceData,
    private val getUserIdUseCase: GetUserIdUseCase,
    private val setDefaultValuesRemoteUseCase: SetDefaultValuesRemoteUseCase
) {
    suspend operator fun invoke(name: String, lastName: String, gender: String, income: Double) {
        val user = profileSourceData.completeProfile(
            getUserIdUseCase.invoke(),
            name,
            lastName,
            gender,
            income
        )
        setDefaultValuesRemoteUseCase(RemoteConfig.Keys.USER_TYPE, user.getTypeUser().name)
    }
}