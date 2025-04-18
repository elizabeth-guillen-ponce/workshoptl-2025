package com.example

import android.app.Application
import android.util.Log
import com.example.workshop_tl.data.di.authDataModule
import com.example.workshop_tl.data.di.firebaseDataModule
import com.example.workshop_tl.domain.di.authDomainModule
import com.example.workshop_tl.presentation.di.authPresentationModule
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.remoteconfig.ktx.remoteConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class WorkshopApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@WorkshopApp)
            modules(
                firebaseDataModule,
                authDataModule,
                authDomainModule,
                authPresentationModule
            )
        }

        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("FirebaseMessaging", "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result

            // Log and toast
            Log.d("FirebaseMessaging", token)
        })
    }
}
