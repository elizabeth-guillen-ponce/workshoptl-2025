package com.example.workshop_tl.domain.analytics

import com.example.workshop_tl.data.analytics.AnalyticsTrack
import com.example.workshop_tl.utils.toSha256

class SetUserIdAnalyticsUseCase(private val analyticsTrack: AnalyticsTrack) {
    operator fun invoke(email: String) {
        analyticsTrack.setUserId(email.toSha256())
    }
}
