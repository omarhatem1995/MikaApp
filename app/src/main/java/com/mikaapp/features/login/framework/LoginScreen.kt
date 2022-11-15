package com.mikaapp.features.login.framework

import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.mikaapp.features.login.application.presentation.LoginViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination(start = true)
fun LoginScreen(navigator: DestinationsNavigator)
{
    val viewModel: LoginViewModel = hiltViewModel()
    val context = LocalContext.current
    val loginLauncher = rememberLauncherForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ) { result ->
        if (result != null) {
           // viewModel.onLoginResult(result)
        }
    }

//    when (signInState.value)
//    {
//        is Response.Success->
//        {
//            if ((signInState.value as Response.Success<String?>).data == null)
//            {
//
//            }else
//            {
//                val id = (signInState.value as Response.Success<String?>).data
//                val state = id?.let { preferences.getAccountState(it) }
//
//                if (state == true)
//                {
//                    navigator.navigate(HomeScreenDestination)
//                }else{
//                    navigator.navigate(ProfileScreenDestination)
//                }
//
//
//
//            }
//
//        }
//
//        is Response.Error ->{
//            LaunchedEffect(key1 = Unit){
//                //scaffoldState.snackbarHostState.showSnackbar((signInState.value as Response.Error).message)
//                Toast.makeText(context,(signInState.value as Response.Error).message, Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        else ->{
//
//        }
//
//
//    }
//
//    LaunchedEffect(key1 = intentState  ){
//
//        if (intentState.value != null)
//        {
//            loginLauncher.launch(intentState.value)
//        }
//
//    }



}