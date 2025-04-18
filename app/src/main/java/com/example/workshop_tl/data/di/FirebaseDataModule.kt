package com.example.workshop_tl.data.di

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.dsl.module

val firebaseDataModule = module {
    single { FirebaseAuth.getInstance() }
    single { FirebaseFirestore.getInstance() }
    single { FirebaseAnalytics.getInstance(get()) }
}
