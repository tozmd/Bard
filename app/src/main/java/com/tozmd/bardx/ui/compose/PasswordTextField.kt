package com.tozmd.bardx.ui.compose

import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(
    password: String,
    passwordVisibility: Boolean,
    onNewValue: (String) -> Unit,
    focusManager: FocusManager
) {
    TextField(
        value = password,
        onValueChange = { onNewValue(it) },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            cursorColor = Color.White,
            containerColor = MaterialTheme.colorScheme.onBackground,
            focusedIndicatorColor = MaterialTheme.colorScheme.onSecondary,
            focusedLabelColor = MaterialTheme.colorScheme.onSecondary,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedLabelColor = MaterialTheme.colorScheme.onPrimary,
            disabledTextColor = Color.Gray,
            unfocusedTrailingIconColor = Color.White,
            focusedTrailingIconColor = Color.White
        ),
        label = { Text("Password") },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .focusable(),
        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Next),
        keyboardActions = KeyboardActions(
            onDone = { focusManager.clearFocus() },
            onNext = { focusManager.moveFocus(FocusDirection.Down)}
        ),
        trailingIcon = {
            val image = if (passwordVisibility)
                Icons.Rounded.Visibility
            else Icons.Filled.VisibilityOff

            val description = if (passwordVisibility) "Hide password" else "Show password"

            IconButton(onClick = { passwordVisibility != passwordVisibility }){
                Icon(imageVector  = image, description)
            }
        }
    )
}