package com.muiezarif.islamicwallpapers

import androidx.multidex.MultiDexApplication
import com.google.firebase.analytics.FirebaseAnalytics

class ApplicationClass: MultiDexApplication() {
    private var instance: ApplicationClass? = null
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    override fun onCreate() {
        super.onCreate()
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)
    }
    init {
        if (instance == null) {
            instance = this
        }
    }
}