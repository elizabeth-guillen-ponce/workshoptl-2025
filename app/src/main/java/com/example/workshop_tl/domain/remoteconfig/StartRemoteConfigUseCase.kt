package com.example.workshop_tl.domain.remoteconfig

import com.example.workshop_tl.data.remoteconfig.RemoteConfigSource

class StartRemoteConfigUseCase(private val remoteConfigSource: RemoteConfigSource) {

    suspend operator fun invoke() {
        remoteConfigSource
    }
}