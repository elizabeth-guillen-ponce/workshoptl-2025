package com.example.workshop_tl.data.cloudmessage

interface CloudMessageRemoteSource {

    suspend fun getToken(): String
}