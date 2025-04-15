package com.example.workshop_tl.domain.profile

import com.example.workshop_tl.data.profile.ProfileSourceData

class GetProfileUserUseCase(private val profileSourceData: ProfileSourceData) {
    suspend operator fun invoke(userId: String) = profileSourceData.getUserProfile(userId)
}