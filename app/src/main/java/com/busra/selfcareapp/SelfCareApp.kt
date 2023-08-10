package com.busra.selfcareapp

import android.app.Application
import com.google.firebase.FirebaseApp

class SelfCareApp: Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}