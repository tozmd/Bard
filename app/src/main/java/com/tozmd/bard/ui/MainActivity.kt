package com.tozmd.bard.ui

//Spotify Dependencies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.spotify.android.appremote.api.ConnectionParams
import com.spotify.android.appremote.api.Connector
import com.spotify.android.appremote.api.SpotifyAppRemote
import com.tozmd.bard.ui.compose.LoginScreen
import com.tozmd.bard.ui.theme.BardXTheme
import com.tozmd.bard.viewmodels.SongRecommendationViewModel


private const val CLIENT_ID = "9bf008306d9d486688a88d4f6a6fe232"
private const val REDIRECT_URI = "http://com.tozmd.bard/callback"
private val mSpotifyAppRemote: SpotifyAppRemote? = null

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //NOTE: INCOMPLETE
        // Set the connection parameters
        /*val connectionParams = ConnectionParams.Builder(CLIENT_ID)
            .setRedirectUri(REDIRECT_URI)
            .showAuthView(true)
            .build()

        SpotifyAppRemote.connect(this, connectionParams,Connector.ConnectionListener)*/

        setContent {
            BardXTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Navigation controller to handle the composables
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "login_screen" //Will be changed
                    ) {
                        composable("login_screen") {
                            //List all composable that will be on this screen
                            LoginScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RecommendationScreen() {
    val recommendationViewModel = remember {SongRecommendationViewModel()}
    val songRecommendationList = recommendationViewModel.status.collectAsState().value
    
    JsonText(jsonText = songRecommendationList)
}

@Composable
fun JsonText(jsonText: String) {
    Text(text =  jsonText)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BardXTheme {
        JsonText("Android")
    }
}

fun authenticateSpotify() {
    
}