package com.mukesh.headlines

import android.os.Bundle
import android.util.Log
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
    val listExisting = mutableListOf<String>("a","b","c","d")
    val incomingList = mutableListOf<String>("a","b","x","y", "z")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val commonList = listExisting.intersect(incomingList)
        Log.e("List", "Common lit ${commonList}")
        val listToBeRemoved = listExisting.toMutableList()
        listToBeRemoved.removeAll(commonList)
        Log.e("List", "To be removed list ${listToBeRemoved}")

        val listToAdded = incomingList.toMutableList()
        listToAdded.removeAll(commonList)
        Log.e("List", "To be added list ${listToAdded}")


        Log.e("List", "listExisting ${listExisting}")

        Log.e("List", "incomingList ${incomingList}")

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

