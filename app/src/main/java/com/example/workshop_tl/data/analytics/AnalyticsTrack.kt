package com.example.workshop_tl.data.analytics

interface AnalyticsTrack {
    fun setUserId(userId: String)
    fun trackEvent(eventName: String, params: Map<String, Any>? = null)
}
