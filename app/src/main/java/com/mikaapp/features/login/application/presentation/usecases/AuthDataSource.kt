package com.mikaapp.features.login.application.presentation.usecases

import android.content.Intent
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

interface AuthDataSource {


    fun buildLoginIntent(): Flow<Intent>

    fun getUser():FirebaseUser?

}