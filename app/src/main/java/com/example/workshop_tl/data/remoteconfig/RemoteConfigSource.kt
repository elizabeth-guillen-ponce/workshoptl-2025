package com.example.workshop_tl.data.remoteconfig

interface RemoteConfigSource {
    suspend fun getValue(key: String): String
    suspend fun setStringConfig(key: String, value: String)
    suspend fun fetchAndActivateConfigParameters()
    var remoteValue: Boolean
}