package com.example.workshop_tl.data.cloudmessage

import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.tasks.await

class CloudMessageRemoteSourceImpl(private val cloudMessageService: FirebaseMessaging) :
    CloudMessageRemoteSource {

    override suspend fun getToken(): String {
        val token = cloudMessageService.token.await()
        Log.d("CloudMessageRemoteSource", "getToken: $token")
        return token
    }
}