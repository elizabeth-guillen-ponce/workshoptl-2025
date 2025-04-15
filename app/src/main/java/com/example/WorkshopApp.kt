package com.example

import android.app.Application
import com.example.workshop_tl.data.di.authDataModule
import com.example.workshop_tl.data.di.firebaseDataModule
import com.example.workshop_tl.domain.di.authDomainModule
import com.example.workshop_tl.presentation.di.authPresentationModule
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
    }
}
