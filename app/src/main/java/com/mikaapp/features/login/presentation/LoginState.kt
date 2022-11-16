package com.mikaapp.features.login.presentation

import android.content.Intent
import de.palm.composestateevents.StateEventWithContent
import de.palm.composestateevents.consumed

data class LoginState(
    val signInStatus:Boolean = false,
    val signInFailedEvent: StateEventWithContent<String> = consumed(),
    val profileStatus:Boolean = false

)
