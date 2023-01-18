package com.mukesh.headlines

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.mukesh.headlines.presentation.common.SetupNavigationSystem
import com.mukesh.headlines.presentation.screens.splash.SplashScreen
import com.mukesh.headlines.ui.theme.ContentColor
import com.mukesh.headlines.ui.theme.HeadlinesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HeadlineApp()
        }
    }
}


@Composable
fun HeadlineApp(
    modifier: Modifier = Modifier,
    sharedViewModel: SharedViewModel = hiltViewModel()
) {
    val thempTheme = isSystemInDarkTheme()
    var isDarkTheme by remember{ mutableStateOf(thempTheme) }
   when(sharedViewModel.themeOption.value){
       "System Theme" ->{
           isDarkTheme = isSystemInDarkTheme()
       }
       "Dark Theme" ->{
           isDarkTheme = true
       }
       "Light Theme" ->{
           isDarkTheme = false
       }
   }

    val systemUiController = rememberSystemUiController()
    val statusBarColor = if (isDarkTheme) ContentColor.StatusBarColorDark else ContentColor.StatusBarColorLight
    systemUiController.setSystemBarsColor(
        color = statusBarColor,
        darkIcons = false
    )

    HeadlinesTheme(darkTheme = isDarkTheme) {
        SplashScreen(modifier, afterSplashScreen = {
            SetupNavigationSystem(sharedViewModel = sharedViewModel)
        })
    }

}

