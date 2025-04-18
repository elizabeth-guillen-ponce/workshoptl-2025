package com.example.workshop_tl.presentation.di

import com.example.workshop_tl.presentation.AuthViewModel
import com.example.workshop_tl.presentation.common.BaseViewModel
import com.example.workshop_tl.presentation.dashboard.ui.main.DashboardViewModel
import com.example.workshop_tl.presentation.userprofile.ui.main.ProfileViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val authPresentationModule = module {
    viewModel { BaseViewModel() }
    viewModel { AuthViewModel(get(), get(), get(), get(), get()) }
    viewModel { ProfileViewModel(get(), get()) }
    viewModel { DashboardViewModel(get()) }
}
