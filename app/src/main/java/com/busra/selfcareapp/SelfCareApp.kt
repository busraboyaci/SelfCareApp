package com.busra.selfcareapp

import android.app.Application
import com.busra.selfcareapp.data.datastore.UserSettingsManager
import com.google.firebase.FirebaseApp

class SelfCareApp: Application() {

    val userSettingsManager: UserSettingsManager by lazy {
        UserSettingsManager(applicationContext)
    }
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}