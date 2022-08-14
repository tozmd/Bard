package com.tozmd.bardx.data.states

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val passwordVisible: Boolean = false
)