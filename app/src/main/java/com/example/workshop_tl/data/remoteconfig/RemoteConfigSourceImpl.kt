package com.example.workshop_tl.data.remoteconfig

import com.example.workshop_tl.R
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import kotlinx.coroutines.tasks.await

class RemoteConfigSourceImpl(private val remoteConfig: FirebaseRemoteConfig) : RemoteConfigSource {

    private var config = false

    override suspend fun setStringConfig(key: String, value: String) {
        remoteConfig.setDefaultsAsync(mapOf(key to value))
    }

    override suspend fun getValue(key: String): String {
        val result = remoteConfig.fetchAndActivate().await()
        return if (result) {
            remoteConfig.getString(key)
        } else {
            ""
        }
    }

    override suspend fun fetchAndActivateConfigParameters() {
        val configSettings = FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(10)
            .build()
        remoteConfig.setConfigSettingsAsync(configSettings).await()
        remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults).await()
        config = remoteConfig.fetchAndActivate().await()
    }

    override var remoteValue: Boolean
        get() = config
        set(value) {}
}