package com.mikaapp.features.login.data.local

import android.content.Context
import com.mikaapp.features.login.application.usecases.datasources.SharedPreferencesDataSource
import com.mikaapp.features.login.data.ports.PreferencesDataSource

class SharedPreferencesSourceImpl (private val preferencesDataSource: PreferencesDataSource): SharedPreferencesDataSource {


   // private val preferences = context.getSharedPreferences("AccountState",Context.MODE_PRIVATE)
    override fun saveAccountState(id: String, state: Boolean) {
       preferencesDataSource.saveAccountState(id,state)


    }

    override fun getAccountState(id: String): Boolean {
        return preferencesDataSource.getAccountState(id)
    }


}