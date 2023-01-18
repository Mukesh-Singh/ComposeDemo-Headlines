package com.mukesh.headlines.presentation.common.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mukesh.headlines.R
import com.mukesh.headlines.presentation.util.Constants
import com.mukesh.headlines.ui.theme.ContentColor
import com.mukesh.headlines.ui.theme.HeadlinesTheme
import com.valentinilk.shimmer.shimmer

/**
Created by Mukesh on 21/10/22
 **/

@Composable
fun CategorisedNewsItemShimmer(modifier: Modifier = Modifier) {
    val shimmerColor = ContentColor.ShimmerColor
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.LightGray),
        //shape = RoundedCornerShape(CornerSize(12.dp))
    ) {
        Column() {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height = Constants.NEWS_ITEM_IMAGE_HEIGHT.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(shimmerColor)
                    .shimmer(),
                painter = painterResource(id = R.drawable.placeholder),
                contentDescription = "Place Holder",
                contentScale = ContentScale.Crop,
            )
            Box(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .width(120.dp)
                    .height(12.dp)
                    .shimmer()
                    .background(shimmerColor)
            )


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .height(16.dp)
                    .shimmer()
                    .background(shimmerColor)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    //.padding(top = 2.dp)
                    .height(16.dp)
                    .shimmer()
                    .background(shimmerColor)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .height(14.dp)
                    .shimmer()
                    .background(shimmerColor)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    //.padding(top = 2.dp)
                    .height(14.dp)
                    .shimmer()
                    .background(shimmerColor)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    //.padding(top = 2.dp)
                    .height(14.dp)
                    .shimmer()
                    .background(shimmerColor)
            )

            Box(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .height(16.dp)
                    .width(250.dp)
                    .shimmer()
                    .background(shimmerColor)
            )

        }

    }
}

@Preview (showBackground = true)
@Composable
fun Preview_CategorisedNewsItemShimmer() {
    HeadlinesTheme {
        CategorisedNewsItemShimmer()
    }
}