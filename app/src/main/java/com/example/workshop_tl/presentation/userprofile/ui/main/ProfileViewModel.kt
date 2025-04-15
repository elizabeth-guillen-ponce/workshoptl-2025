package com.example.workshop_tl.presentation.userprofile.ui.main

import com.example.workshop_tl.domain.profile.CreateProfileUserUseCase
import com.example.workshop_tl.presentation.Screens
import com.example.workshop_tl.presentation.common.BaseViewModel

class ProfileViewModel(private val createProfileUser: CreateProfileUserUseCase) : BaseViewModel() {

    fun onSaveClicked(name: String, lastName: String, gender: String) {
        launchCatching {
            createProfileUser(name, lastName, gender)
            navToScreen(Screens.DASHBOARD)
        }
    }
}