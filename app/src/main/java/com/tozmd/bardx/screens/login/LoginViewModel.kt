package com.tozmd.bardx.screens.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.tozmd.bardx.data.states.LoginUiState
import com.tozmd.bardx.services.AccountService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject



@HiltViewModel
class LoginViewModel @Inject constructor(
    private val accountService: AccountService
): ViewModel() {
    //LoginScreen observes uiState for changes
    var uiState = mutableStateOf(LoginUiState())
        private set

    private val email get() = uiState.value.email
    private val password get() = uiState.value.password
    private val passwordVisibility get() = uiState.value.passwordVisible

    //Updates email when changed
    fun onEmailChange(newValue: String) {
        uiState.value = uiState.value.copy(email = newValue)
    }

    fun onPasswordChange(newValue: String) {
        uiState.value = uiState.value.copy(password = newValue)
    }

}

