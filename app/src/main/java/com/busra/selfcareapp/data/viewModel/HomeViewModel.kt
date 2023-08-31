package com.busra.selfcareapp.data.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.busra.selfcareapp.navigate.Screen
import com.busra.selfcareapp.navigate.SelfCareAppRouter
import com.google.firebase.auth.FirebaseAuth

class HomeViewModel(): ViewModel() {
    private val TAG = HomeViewModel::class.simpleName


    fun logout(){
        val firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.signOut()

        val authStateListener = FirebaseAuth.AuthStateListener {
            if (it.currentUser == null) {
                Log.d(TAG, "authStateListener")
                SelfCareAppRouter.navigateTo(Screen.LoginScreen)
            } else {
                Log.d(TAG, "logout not complete")
            }
        }
        firebaseAuth.addAuthStateListener(authStateListener)
    }
}
