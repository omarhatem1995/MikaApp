package com.mikaapp.features.login.application.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import com.mikaapp.features.login.application.presentation.usecases.SharedPreferencesDataSource
import com.mikaapp.features.login.application.presentation.usecases.SignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCases: SignInUseCase,
                                         private val preferences:SharedPreferencesDataSource): ViewModel() {


}