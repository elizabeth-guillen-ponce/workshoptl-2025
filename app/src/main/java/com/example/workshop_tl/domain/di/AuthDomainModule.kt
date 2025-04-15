package com.example.workshop_tl.domain.di

import com.example.workshop_tl.domain.auth.GetCurrentUserUseCase
import com.example.workshop_tl.domain.auth.GetUserIdUseCase
import com.example.workshop_tl.domain.auth.LoginUseCase
import com.example.workshop_tl.domain.auth.SignOutUseCase
import com.example.workshop_tl.domain.auth.SignUpUseCase
import org.koin.dsl.module

val authDomainModule = module {
    single { LoginUseCase(authManager = get()) }
    single { SignUpUseCase(authManager = get()) }
    single { SignOutUseCase(authManager = get()) }
    single { GetCurrentUserUseCase(authManager = get()) }
    single { GetUserIdUseCase(authManager = get()) }
}
