package com.mikaapp.features.login.application.presentation.usecases

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SignInUseCase @Inject constructor(private val authSource: AuthDataSource) {



    fun launchSignInIntent(): Flow<Any>
    {
      return authSource.buildLoginIntent()
    }





    fun getAuthUser() = authSource.getUser()
}