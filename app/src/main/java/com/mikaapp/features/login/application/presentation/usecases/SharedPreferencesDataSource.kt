package com.mikaapp.features.login.application.presentation.usecases

interface SharedPreferencesDataSource {


    fun saveAccountState(id:String,state:Boolean)

    fun getAccountState(id:String):Boolean
}