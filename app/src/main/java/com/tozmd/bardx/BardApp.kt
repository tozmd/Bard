package com.tozmd.bardx

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.DrawerValue
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tozmd.bardx.data.states.rememberAppState
import com.tozmd.bardx.screens.login.LoginScreen
import com.tozmd.bardx.ui.theme.BardXTheme


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BardApp() {
    BardXTheme {
        // A surface container using the 'background' color from the theme
        val appState = rememberAppState()
        //No drawer used
        val scaffoldState = rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
        val coroutineScope = rememberCoroutineScope()

        Scaffold(
            topBar = {
                TopAppBar(

                ) {

                }
            }
        ) {
            LoginScreen(popUpScreen = { /*TODO*/ })
        }
        //Navigation controller to handle the composableZ

        /*val scaffoldState = rememberScaffoldState()
        Scaffold(

        )
*/
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = "login_screen" //Will be changed
        ) {
            composable("login_screen") {
                //List all composable that will be on this screen
                //LoginScreen()
            }
        }
    }
}