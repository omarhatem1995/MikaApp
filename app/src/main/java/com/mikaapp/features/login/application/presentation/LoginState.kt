package com.mikaapp.features.login.application.presentation

import android.content.Intent
import de.palm.composestateevents.StateEventWithContent
import de.palm.composestateevents.consumed

data class LoginState(
    val signInStatus:Boolean = false,
    val signInIntent: Intent?,
    val SignInFailedEvent: StateEventWithContent<String> = consumed()

)
