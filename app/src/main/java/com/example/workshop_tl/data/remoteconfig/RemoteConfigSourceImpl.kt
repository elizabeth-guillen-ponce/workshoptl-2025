package com.example.workshop_tl.data.remoteconfig

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import kotlinx.coroutines.tasks.await

class RemoteConfigSourceImpl(private val remoteConfig: FirebaseRemoteConfig) : RemoteConfigSource {
    override suspend fun getStringConfig(key: String): String {
        val result = remoteConfig.fetchAndActivate().await()
        return if (result) {
            remoteConfig.getString(key)
        } else {
            ""
        }
    }

    override suspend fun getIntConfig(key: String): Long {
        val result = remoteConfig.fetchAndActivate().await()
        return if (result) {
            remoteConfig.getLong(key)
        } else {
            0L
        }
    }

    override suspend fun setStringConfig(key: String, value: String) {
        remoteConfig.setDefaultsAsync(mapOf(key to value))
    }
}