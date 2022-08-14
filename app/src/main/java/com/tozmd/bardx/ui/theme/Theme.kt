package com.tozmd.bardx.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalView
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorScheme = darkColorScheme(
    primary =  SoftBlue500,
    onPrimary = SoftBlue100,
    secondary = Gold500,
    onSecondary = Gold100,
    tertiary = CoolGrey500,
    background = CoolGrey1000,
    onBackground = CoolGrey800
)

@Composable
fun BardXTheme(
    content: @Composable () -> Unit
) {
        val colorScheme = DarkColorScheme
    //If working with light/dark themes
    /*val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }*/

    val view = LocalView.current

//    if (!view.isInEditMode) {
//        SideEffect {
//            (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
//            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
//        }
//    }

    //Change color of status bar (bar on top)
    val systemUiController = rememberSystemUiController()
        systemUiController.setSystemBarsColor(color = DarkColorScheme.background)

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}