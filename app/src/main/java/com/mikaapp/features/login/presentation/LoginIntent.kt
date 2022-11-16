package com.mikaapp.features.login.presentation

sealed class LoginIntent
{
    object signIn: LoginIntent()
}
