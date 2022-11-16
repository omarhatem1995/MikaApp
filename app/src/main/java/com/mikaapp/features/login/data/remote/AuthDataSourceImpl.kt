package com.mikaapp.features.login.data.remote

import android.content.Intent
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.mikaapp.R
import com.mikaapp.features.login.application.entities.plain.AuthUser
import com.mikaapp.features.login.application.usecases.datasources.AuthDataSource
import com.mikaapp.features.login.data.ports.AuthenticatorDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthDataSourceImpl @Inject constructor(private  val authenticatorDataSource: AuthenticatorDataSource): AuthDataSource {



    override fun buildLoginIntent(): Flow<Intent> {

        return flow {



            emit(authenticatorDataSource.buildAuthIntent() as Intent)
        }
    }

    override fun getUser(): AuthUser? {
        return authenticatorDataSource.getUser()
    }





    }

