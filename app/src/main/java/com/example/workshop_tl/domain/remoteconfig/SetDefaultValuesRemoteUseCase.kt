package com.example.workshop_tl.domain.remoteconfig

import com.example.workshop_tl.data.remoteconfig.RemoteConfigSource

class SetDefaultValuesRemoteUseCase(private val remoteConfigSource: RemoteConfigSource) {

    suspend operator fun invoke(key: String, value: String) {
        remoteConfigSource.setStringConfig(key, value)
    }

}