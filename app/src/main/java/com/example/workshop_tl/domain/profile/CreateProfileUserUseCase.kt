package com.example.workshop_tl.domain.profile

import com.example.workshop_tl.data.profile.ProfileSourceData
import com.example.workshop_tl.domain.session.GetUserIdUseCase

class CreateProfileUserUseCase(
    private val profileSourceData: ProfileSourceData,
    private val getUserIdUseCase: GetUserIdUseCase
) {
    suspend operator fun invoke(name: String, lastName: String, gender: String, income: Double) {
        profileSourceData.completeProfile(getUserIdUseCase.invoke(), name, lastName, gender, income)
    }
}