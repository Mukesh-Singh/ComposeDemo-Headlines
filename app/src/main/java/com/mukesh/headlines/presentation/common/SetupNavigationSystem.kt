package com.mukesh.headlines.presentation.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mukesh.headlines.SharedViewModel
import com.mukesh.headlines.presentation.rout.Rout
import com.mukesh.headlines.presentation.screens.home.HomeScreen
import com.mukesh.headlines.presentation.screens.view_all.ViewAllTopHeadLinesScreen

/**
Created by Mukesh on 02/11/22
 **/

@Composable
fun SetupNavigationSystem(
    modifier: Modifier = Modifier,
    sharedViewModel: SharedViewModel? = null,
) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Rout.HOME.rout
    ) {
        composable(route = Rout.HOME.rout) {
            HomeScreen(
                modifier= Modifier.fillMaxSize(),
                navController = navController,
                sharedViewModel = sharedViewModel,
            )
        }
        composable(route = Rout.HEADLINE_VIEW_ALL.rout) {
            //view all list
            ViewAllTopHeadLinesScreen(
                navController = navController,
                sharedViewModel = sharedViewModel,
            )
        }
        composable(
            Rout.NEWS_DETAILS.rout,
            arguments = listOf(navArgument("news_id") { type = NavType.StringType })
        ) {
            val id = it.arguments?.getString("news_id")
            //id?.let { it1 -> DetailsScreen(Modifier.padding(innerPadding), navHostController = navController, id = it1) }
        }
    }

}