package com.example.workshop_tl.data.di

import com.example.workshop_tl.data.auth.AppAuthManager
import com.example.workshop_tl.data.auth.AppAuthManagerImpl
import com.example.workshop_tl.data.profile.ProfileSourceData
import com.example.workshop_tl.data.profile.ProfileSourceDataImpl
import com.example.workshop_tl.data.session.SessionRemoteSource
import com.example.workshop_tl.data.session.SessionRemoteSourceImpl
import com.google.firebase.auth.FirebaseAuth
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

val authDataModule = module {
    single<AppAuthManager> {
        AppAuthManagerImpl(
            auth = get()
        )
    }
    single<SessionRemoteSource> {
        SessionRemoteSourceImpl(
            auth = get()
        )
    }
    single<ProfileSourceData> {
        ProfileSourceDataImpl(
            firestore = get()
        )
    }

}
