package com.mukesh.headlines.presentation.screens.home.components.shimmer

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
Created by Mukesh on 21/10/22
 **/

@Composable
fun NewsItemsShimmerWithStyleWraper(modifier: Modifier = Modifier,  content: @Composable () -> Unit) {
    Column(
        //modifier= modifier.padding(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        content()
    }
}

