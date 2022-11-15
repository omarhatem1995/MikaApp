package com.mikaapp.features.login.application.data.remote

import android.content.Intent
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.mikaapp.R
import com.mikaapp.features.login.application.presentation.usecases.AuthDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AuthRepositoryImpl: AuthDataSource {

    private val providers = arrayListOf(
        AuthUI.IdpConfig.EmailBuilder().build(),
        AuthUI.IdpConfig.GoogleBuilder().build()
    )

    override fun buildLoginIntent(): Flow<Intent> {

// Create and launch sign-in intent
//        val layout = AuthMethodPickerLayout
//            .Builder(R.layout.signin_layout)
//            .setGoogleButtonId(R.id.googleBtn)
//            .setEmailButtonId(R.id.email_button)
//            .setPhoneButtonId(R.id.phone_button)
//            .build()


        return flow {

            val intent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
               .setLogo(R.drawable.mika)
                .setTheme(R.style.Theme_MikaApp)
                //.setAuthMethodPickerLayout(layout)
                .setIsSmartLockEnabled(false)
                .build()

            emit(intent)
        }
    }

    override fun getUser(): FirebaseUser? {
        return FirebaseAuth.getInstance().currentUser
    }





    }

