package com.example.workshop_tl.domain.analytics

import com.example.workshop_tl.data.analytics.AnalyticsTrack

class TrackUserPropertiesUseCase(private val analyticsTrack: AnalyticsTrack) {
    operator fun invoke(properties: Map<String, String>) {
        analyticsTrack.trackUserProperties(properties)
    }
}