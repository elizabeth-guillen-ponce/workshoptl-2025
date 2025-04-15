package com.example.workshop_tl.presentation.di

import com.example.workshop_tl.presentation.AuthViewModel
import com.example.workshop_tl.presentation.common.BaseViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val authPresentationModule = module {
    viewModel { BaseViewModel() }
    viewModel { AuthViewModel(get(), get()) }
}
