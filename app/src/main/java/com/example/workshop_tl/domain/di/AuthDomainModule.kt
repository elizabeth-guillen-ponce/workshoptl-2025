package com.example.workshop_tl.domain.di

import com.example.workshop_tl.domain.session.GetCurrentUserUseCase
import com.example.workshop_tl.domain.session.GetUserIdUseCase
import com.example.workshop_tl.domain.auth.LoginUseCase
import com.example.workshop_tl.domain.auth.SignOutUseCase
import com.example.workshop_tl.domain.auth.SignUpUseCase
import com.example.workshop_tl.domain.dashboard.GetDashboardItemsUseCase
import com.example.workshop_tl.domain.profile.CreateProfileUserUseCase
import com.example.workshop_tl.domain.profile.GetProfileUserUseCase
import org.koin.dsl.module

val authDomainModule = module {
    single { LoginUseCase(authManager = get()) }
    single { SignUpUseCase(authManager = get()) }
    single {
        SignOutUseCase(
            authManager = get(),
            sessionRemoteSource = get()
        )
    }
    single { GetCurrentUserUseCase(sessionRemoteSource = get()) }
    single { GetUserIdUseCase(getCurrentUserUseCase = get()) }
    single { CreateProfileUserUseCase(profileSourceData = get(), getUserIdUseCase = get()) }
    single { GetProfileUserUseCase(profileSourceData = get()) }
    single { GetDashboardItemsUseCase(getUserIdUseCase = get(), getProfileUserUseCase = get()) }
}
