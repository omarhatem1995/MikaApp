package com.mikaapp.features.login.application.presentation

sealed class LoginIntent
{
    object signIn:LoginIntent()
}
