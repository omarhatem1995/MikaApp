package com.mikaapp.features.login.framework.local

import android.content.Context
import android.content.SharedPreferences
import com.mikaapp.features.login.data.ports.PreferencesDataSource
import javax.inject.Inject

class PreferencesGateWay @Inject constructor(private val sharedPreferences:SharedPreferences) : PreferencesDataSource {
    override fun saveAccountState(id: String, state: Boolean) {
        sharedPreferences.edit().putBoolean(id,state).apply()
    }

    override fun getAccountState(id: String): Boolean {
       return sharedPreferences.getBoolean(id,false)
    }
}