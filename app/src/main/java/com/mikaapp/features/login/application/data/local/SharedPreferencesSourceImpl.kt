package com.mikaapp.features.login.application.data.local

import android.content.Context
import com.mikaapp.features.login.application.presentation.usecases.SharedPreferencesDataSource

class SharedPreferencesSourceImpl (private val context: Context): SharedPreferencesDataSource {


    private val preferences = context.getSharedPreferences("AccountState",Context.MODE_PRIVATE)
    override fun saveAccountState(id: String, state: Boolean) {
        preferences.edit().putBoolean(id,state).apply()

    }

    override fun getAccountState(id: String): Boolean {
        return preferences.getBoolean(id,false)
    }


}