package com.example.workshop_tl.domain.cloudmessage

import com.example.workshop_tl.data.cloudmessage.CloudMessageRemoteSource

class GetFirebaseTokenUseCase(private val cloudMessageRemoteSource: CloudMessageRemoteSource) {

    suspend operator fun invoke() {
        cloudMessageRemoteSource.getToken()
    }
}