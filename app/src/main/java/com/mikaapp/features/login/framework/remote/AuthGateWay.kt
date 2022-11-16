package com.mikaapp.features.login.framework.remote

import android.annotation.SuppressLint
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.mikaapp.R
import com.mikaapp.features.login.application.entities.plain.AuthUser
import com.mikaapp.features.login.data.ports.AuthenticatorDataSource
import javax.inject.Inject

class AuthGateWay @Inject constructor(private val authUI: AuthUI, private val firebaseAuth: FirebaseAuth) :AuthenticatorDataSource {

    private val providers = arrayListOf(
        AuthUI.IdpConfig.EmailBuilder().build(),
        AuthUI.IdpConfig.GoogleBuilder().build()
    )

    override fun buildAuthIntent(): Any {
        return  authUI
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .setLogo(R.drawable.mika)
            .setTheme(R.style.Theme_MikaApp)
            //.setAuthMethodPickerLayout(layout)
            .setIsSmartLockEnabled(false)
            .build()
    }

    @SuppressLint("SuspiciousIndentation")
    override fun getUser(): AuthUser? {
     val user = firebaseAuth.currentUser
        return if (user != null) {
            AuthUser(user.uid)
        }else
            null

    }
}