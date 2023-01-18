package com.mukesh.headlines.presentation.screens.home.components.shimmer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mukesh.headlines.presentation.common.component.CardShimmer
import com.mukesh.headlines.presentation.util.Constants
import com.mukesh.headlines.ui.theme.HeadlinesTheme

/**
Created by Mukesh on 19/10/22
 **/

@Composable
fun TopHeadlineShimmer(modifier: Modifier = Modifier){
    Column(modifier = modifier) {
        LazyRow(
            modifier = Modifier,
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
            items(5){
                Column(
                    modifier = Modifier.height(Constants.BIG_CARD_HEIGHT.dp)
                ) {
                    CardShimmer()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HeadlinesTheme {
        TopHeadlineShimmer()
    }
}