package com.mikaapp.features.login.data.ports

interface PreferencesDataSource {

    fun saveAccountState(id:String,state:Boolean)

    fun getAccountState(id:String):Boolean
}