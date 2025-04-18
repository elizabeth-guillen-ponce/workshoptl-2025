package com.example.workshop_tl.domain.remoteconfig

import com.example.workshop_tl.data.remoteconfig.RemoteConfigSource

class GetStringValueRemoteUseCase(private val remoteConfigSource: RemoteConfigSource) {
    suspend operator fun invoke(key: String) = remoteConfigSource.getStringConfig(key)
}