package com.mukesh.headlines.presentation.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mukesh.headlines.ui.theme.ContentColor
import com.mukesh.headlines.ui.theme.HeadlinesTheme
import com.valentinilk.shimmer.shimmer

/**
Created by Mukesh on 21/10/22
 **/

@Composable
fun ChipShimmer(modifier: Modifier= Modifier) {
    Surface(
        modifier = modifier
            .shimmer(),
        shape = RoundedCornerShape(16.dp),

    ) {
        Box(modifier = modifier
            .background(ContentColor.ShimmerColor)
            .height(32.dp)
            .width(100.dp)
            .shimmer()
        ) {

        }
    }
}

@Preview
@Composable
fun Preview_ChipShimmer(){
    HeadlinesTheme {
        ChipShimmer()
    }
}