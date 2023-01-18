package com.mukesh.headlines.presentation.common.component

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
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
Created by Mukesh on 19/10/22
 **/

@Composable
fun CardShimmer(modifier: Modifier = Modifier){
    Surface(
        modifier = modifier
            //.fillMaxWidth()
            //.padding(vertical = 4.dp)
            .height(height = Constants.BIG_CARD_HEIGHT.dp)
            .width(Constants.BIG_CARD_WIDTH.dp)
            ,

        shape = RoundedCornerShape(CornerSize(12.dp))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                //.shimmer()
                //.background(ContentColor.ShimmerColor)
            ,
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(12.dp))
                    .background(ContentColor.ShimmerColor)
                    .shimmer()
                ,
                painter = painterResource(id = R.drawable.placeholder),
                contentDescription = "Place Holder",
                contentScale = ContentScale.Crop,


            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 24.dp)
                ,
                verticalArrangement = Arrangement.Center,
                //verticalArrangement = Arrangement.spacedBy(16.dp),

            ) {
                Box(
                    modifier = Modifier
                        .size(120.dp, 12.dp)
                        .shimmer()
                        .background(Color.Gray)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                        .height(20.dp)
                        .shimmer()
                        .background(Color.Gray)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 2.dp)
                        .height(20.dp)
                        .shimmer()
                        .background(Color.Gray)
                )


            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 16.dp)
                ,
                verticalArrangement = Arrangement.Bottom,

            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(14.dp)
                        .shimmer()
                        .background(Color.Gray)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 2.dp)
                        .height(14.dp)
                        .shimmer()
                        .background(Color.Gray)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 2.dp)
                        .height(14.dp)
                        .shimmer()
                        .background(Color.Gray)
                )

            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun Preview_CardShimmer() {
    HeadlinesTheme {
        CardShimmer()
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun Preview_CardShimmer_dark() {
    HeadlinesTheme {
        CardShimmer()
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun Preview_CardShimmer_light() {
    HeadlinesTheme {
        CardShimmer()
    }
}