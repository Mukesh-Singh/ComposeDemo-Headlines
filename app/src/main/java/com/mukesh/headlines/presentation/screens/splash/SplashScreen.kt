package com.mukesh.headlines.presentation.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.mukesh.headlines.R

@Composable
fun SplashScreen(modifier: Modifier = Modifier, afterSplashScreen: @Composable () -> Unit) {
    var splashCompleted by rememberSaveable { mutableStateOf(false)}
    if (!splashCompleted) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.status_bar_color))
        ) {
            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.news_splash_lotte_icon))
            val logoAnimationState =
                animateLottieCompositionAsState(composition = composition)
            LottieAnimation(
                composition = composition,
                progress = { logoAnimationState.progress }
            )
            if (logoAnimationState.isAtEnd && logoAnimationState.isPlaying) {
                splashCompleted = true
            }
        }
    }else{
        afterSplashScreen()
    }
}