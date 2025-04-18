package com.example.workshop_tl.data.analytics

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

class AnalyticsTrackImpl(private val analytics: FirebaseAnalytics) : AnalyticsTrack {

    override fun setUserId(userId: String) {
        analytics.setUserId(userId)
    }

    override fun trackEvent(
        eventName: String,
        params: Map<String, Any>?
    ) {
        analytics.logEvent(eventName, getBundle(params))

    }

    private fun getBundle(params: Map<String, Any>?): Bundle? {
        if(params == null) return null

        val bundle = Bundle()
        params.forEach { key, value ->
            when (value) {
                is Boolean -> bundle.putBoolean(key, value)
                is Int -> bundle.putInt(key, value)
                is Double -> bundle.putDouble(key, value)
                is Float -> bundle.putFloat(key, value)
                else -> bundle.putString(key, value.toString())
            }
        }
        return bundle
    }
}
