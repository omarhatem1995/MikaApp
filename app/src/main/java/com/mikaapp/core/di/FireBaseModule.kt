package com.mikaapp.core.di

import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FireBaseModule {


    @Provides
    @Singleton
    fun providesFireAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun providesFireAuthUI(): AuthUI = AuthUI.getInstance()

    @Provides
    @Singleton
    fun providesFireStorage(): FirebaseStorage = FirebaseStorage.getInstance()


    @Provides
    @Singleton
    fun providesFireDataBase(): FirebaseDatabase {
        val database =FirebaseDatabase.getInstance().apply {
            setPersistenceEnabled(true)
        }

        return database
    }
}