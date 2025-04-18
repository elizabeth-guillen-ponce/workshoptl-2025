package com.example.workshop_tl.domain.analytics

import com.example.workshop_tl.data.analytics.AnalyticsTrack

class TrackEventUseCase(private val analyticsTrack: AnalyticsTrack) {
    operator fun invoke(eventName: String, params: Map<String, Any>? = null) {
        analyticsTrack.trackEvent(eventName, params)
    }
}