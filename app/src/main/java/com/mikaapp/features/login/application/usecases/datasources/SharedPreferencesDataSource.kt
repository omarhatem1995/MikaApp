package com.mikaapp.features.login.application.usecases.datasources

interface SharedPreferencesDataSource {


    fun saveAccountState(id:String,state:Boolean)

    fun getAccountState(id:String):Boolean
}