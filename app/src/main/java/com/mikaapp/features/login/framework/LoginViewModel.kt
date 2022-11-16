package com.mikaapp.features.login.framework

import android.content.Intent
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.mikaapp.features.login.application.usecases.datasources.SharedPreferencesDataSource
import com.mikaapp.features.login.application.usecases.SignInUseCase
import com.mikaapp.features.login.presentation.LoginIntent
import com.mikaapp.features.login.presentation.LoginState
import com.mikaapp.features.login.presentation.LoginStateMapper
import dagger.hilt.android.lifecycle.HiltViewModel

import de.palm.composestateevents.consumed
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCases: SignInUseCase,
                                         private val preferences: SharedPreferencesDataSource,
                                         private val loginStateMapper: LoginStateMapper
): ViewModel() {

    private val _signInIntent: MutableState<Intent?> = mutableStateOf(null)

    val signInIntent: State<Intent?>
        get() = _signInIntent

    private val initialState = LoginState()
    private val _loginState: MutableStateFlow<LoginState?> = MutableStateFlow(initialState)

    val loginState: StateFlow<LoginState?> = _loginState.asStateFlow().stateIn(viewModelScope,started = SharingStarted.WhileSubscribed(5000),initialState)



    init {
        handleIntent()
    }

    //this function normally is exposed (public) for the view to send user events
     fun handleIntent(uiEvent: LoginIntent= LoginIntent.signIn)
    {
        when(uiEvent)
        {
            is LoginIntent.signIn -> signUp()
        }

    }


   private fun signUp(){

        val user = authUseCases.getAuthUser()
        if (user != null) {
            val state = user.id?.let { preferences.getAccountState(it) }
            // User is signed in
           _loginState.value = LoginState(true, consumed(),state!!)

        } else {
            // No user is signed in
            viewModelScope.launch {
                authUseCases.launchSignInIntent().collect {

                    _signInIntent.value = it as Intent

                }
            }

        }

    }

    fun onLoginResult(result: FirebaseAuthUIAuthenticationResult)
    {
        _loginState.value = loginStateMapper.invoke(result)
    }
}