package com.example.workshop_tl.data.remoteconfig

interface RemoteConfigSource {
    suspend fun getStringConfig(key: String): String
    suspend fun getIntConfig(key: String): Long
    suspend fun setStringConfig(key: String, value: String)
}