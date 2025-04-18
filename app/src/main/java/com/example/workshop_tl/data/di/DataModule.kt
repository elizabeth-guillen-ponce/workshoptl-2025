package com.example.workshop_tl.data.di

import com.example.workshop_tl.data.analytics.AnalyticsTrack
import com.example.workshop_tl.data.analytics.AnalyticsTrackImpl
import com.example.workshop_tl.data.auth.AppAuthManager
import com.example.workshop_tl.data.auth.AppAuthManagerImpl
import com.example.workshop_tl.data.cloudmessage.CloudMessageRemoteSource
import com.example.workshop_tl.data.cloudmessage.CloudMessageRemoteSourceImpl
import com.example.workshop_tl.data.profile.ProfileSourceData
import com.example.workshop_tl.data.profile.ProfileSourceDataImpl
import com.example.workshop_tl.data.remoteconfig.RemoteConfigSource
import com.example.workshop_tl.data.remoteconfig.RemoteConfigSourceImpl
import com.example.workshop_tl.data.session.SessionRemoteSource
import com.example.workshop_tl.data.session.SessionRemoteSourceImpl
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
    single<AnalyticsTrack> {
        AnalyticsTrackImpl(analytics = get())
    }
    single<RemoteConfigSource> {
        RemoteConfigSourceImpl(remoteConfig = get())
    }
    single<CloudMessageRemoteSource> {
        CloudMessageRemoteSourceImpl(cloudMessageService = get())
    }
}
