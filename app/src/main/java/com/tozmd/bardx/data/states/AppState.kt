package com.tozmd.bardx.data.states

import android.content.res.Resources
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class AppState(
    val scaffoldState: ScaffoldState,
    val navController: NavHostController,
    private val resources: Resources,
) {
/*    val bottomBarTabs = *//* State *//*

    // Logic to decide when to show the bottom bar
    val shouldShowBottomBar: Boolean
        get() = *//* ... *//*

    // Navigation logic, which is a type of UI logic
    fun navigateToBottomBarRoute(route: String) { *//* ... *//* }

    // Show snackbar using Resources
    fun showSnackbar(message: String) { *//* ... *//* }*/
}

@Composable
fun rememberAppState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavHostController = rememberNavController(),
    resources: Resources = LocalContext.current.resources,
    /* ... */
) = remember(scaffoldState, navController, resources) {
    AppState(scaffoldState, navController, resources)
}