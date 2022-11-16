package com.mikaapp.features.login.application.usecases.datasources

import com.mikaapp.features.login.application.entities.plain.AuthUser
import kotlinx.coroutines.flow.Flow

interface AuthDataSource {


    fun buildLoginIntent(): Flow<Any>

    fun getUser():AuthUser?

}