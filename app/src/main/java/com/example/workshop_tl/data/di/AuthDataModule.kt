package com.example.workshop_tl.data.di

import com.example.workshop_tl.data.auth.AppAuthManager
import com.example.workshop_tl.data.auth.AppAuthManagerImpl
import com.google.firebase.auth.FirebaseAuth
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val authDataModule = module {
    single { FirebaseAuth.getInstance() }
    single {
        AppAuthManagerImpl(
            auth = get()
        )
    }
    singleOf(::AppAuthManagerImpl) {
        bind<AppAuthManager>()
    }
}
