package com.example.workshop_tl.data.di

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.remoteconfig.ktx.remoteConfig
import org.koin.dsl.module

val firebaseDataModule = module {
    single { FirebaseAuth.getInstance() }
    single { FirebaseFirestore.getInstance() }
    single { FirebaseAnalytics.getInstance(get()) }
    single {
        Firebase.remoteConfig
    }
    single {
        FirebaseMessaging.getInstance()
    }
}
