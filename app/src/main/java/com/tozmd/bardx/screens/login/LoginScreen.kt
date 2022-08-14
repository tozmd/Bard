package com.tozmd.bardx.screens.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.tozmd.bardx.ui.compose.AutoFocusTextField
import com.tozmd.bardx.ui.compose.LabeledButton
import com.tozmd.bardx.ui.compose.PasswordTextField
import androidx.hilt.navigation.compose.hiltViewModel


//User login screen
@Composable
fun LoginScreen(
    popUpScreen: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
    //To observe changes in login viewModel
    val uiState by viewModel.uiState

    val margin = 25.dp

    //Manage focus for login screen
    val focusManager = LocalFocusManager.current
    //Stream of interactions
    val interactionSource = MutableInteractionSource()

    //On tap remove focus from text field
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                //Disable the ripple animation
                interactionSource = interactionSource,
                indication = null
            ) {
                focusManager.clearFocus()
            }
    )
    //Container for screen composables
    Column(
        modifier = Modifier.padding(margin)
    )
    {
        Spacer(modifier = Modifier.height(80.dp))
        Text("Welcome back.",
            style = MaterialTheme.typography.titleMedium,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text("Sign in to your account",
            style = MaterialTheme.typography.bodySmall,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(40.dp))
        //Container for text fields
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Runs function when value changed
            AutoFocusTextField(uiState.email, viewModel::onEmailChange, focusManager)
            Spacer(modifier = Modifier.height(25.dp))
            PasswordTextField(uiState.password, uiState.passwordVisible, viewModel::onPasswordChange, focusManager)
        }
        TextButton(
            onClick = { /*TODO*/ },
            Modifier.align(Alignment.End)
        ) {
            Text(
                "Forgot Password?",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
        Column(modifier = Modifier
            .imePadding()
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            LabeledButton("Continue", 0.95f, 50)
        }
    }
}

