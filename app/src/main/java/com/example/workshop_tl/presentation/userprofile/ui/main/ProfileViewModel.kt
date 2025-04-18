package com.example.workshop_tl.presentation.userprofile.ui.main

import com.example.workshop_tl.domain.analytics.TrackEventUseCase
import com.example.workshop_tl.domain.profile.CreateProfileUserUseCase
import com.example.workshop_tl.presentation.Screens
import com.example.workshop_tl.presentation.common.BaseViewModel

class ProfileViewModel(
    private val createProfileUser: CreateProfileUserUseCase,
    private val trackEventUseCase: TrackEventUseCase
) : BaseViewModel() {

    fun onSaveClicked(name: String, lastName: String, gender: String, income: Double) {
        launchCatching {
            createProfileUser(name, lastName, gender, income)
            trackEventUseCase(
                "save_profile",
                mapOf(
                    "name" to name,
                    "last_name" to lastName,
                    "gender" to gender,
                    "income" to income
                )
            )
            navToScreen(Screens.DASHBOARD)
        }
    }
}