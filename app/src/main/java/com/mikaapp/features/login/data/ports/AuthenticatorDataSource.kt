package com.mikaapp.features.login.data.ports

import com.mikaapp.features.login.application.entities.plain.AuthUser

interface AuthenticatorDataSource {

    fun buildAuthIntent():Any

    fun getUser():AuthUser?
}