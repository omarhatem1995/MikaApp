package com.mikaapp.features.login.presentation

import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import javax.inject.Inject

class LoginStateMapper @Inject constructor():
    Function1<FirebaseAuthUIAuthenticationResult, LoginState> {
    override fun invoke(p1: FirebaseAuthUIAuthenticationResult): LoginState {
        TODO("Not yet implemented")

    }
}