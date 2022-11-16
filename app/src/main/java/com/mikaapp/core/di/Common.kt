package com.mikaapp.core.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Common {


    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context) = context.getSharedPreferences("Mika",Context.MODE_PRIVATE)
}