package com.mikaapp.features.login.framework.di

import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.mikaapp.core.di.FireBaseModule
import com.mikaapp.features.login.application.usecases.SignInUseCase
import com.mikaapp.features.login.application.usecases.datasources.AuthDataSource
import com.mikaapp.features.login.data.ports.AuthenticatorDataSource
import com.mikaapp.features.login.data.remote.AuthDataSourceImpl
import com.mikaapp.features.login.framework.remote.AuthGateWay
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [FireBaseModule::class])
@InstallIn(SingletonComponent::class)
object LoginModule {


    @Provides
    @Singleton
    fun provideAuthenticator( authUI: AuthUI, firebaseAuth: FirebaseAuth): AuthenticatorDataSource = AuthGateWay(authUI, firebaseAuth)

    @Provides
    @Singleton
    fun provideAuthDataSource(authenticatorDataSource: AuthenticatorDataSource): AuthDataSource = AuthDataSourceImpl(authenticatorDataSource)


    @Provides
    @Singleton
    fun provideAuthUseCases(dataSource: AuthDataSource): SignInUseCase = SignInUseCase(dataSource)
}