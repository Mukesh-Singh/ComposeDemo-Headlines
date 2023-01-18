package com.mukesh.headlines.presentation.screens.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mukesh.headlines.presentation.common.component.CardShimmer
import com.mukesh.headlines.presentation.common.component.HeadlineHorizontalCard
import com.mukesh.headlines.presentation.util.Constants
import com.mukesh.module.domain.model.network.News

/**
Created by Mukesh on 20/10/22
 **/

@Composable
fun TopHeadlineHorizontalSection(modifier: Modifier = Modifier, newsList: List<News>) {
    Column(modifier = modifier) {
        LazyRow(
            modifier = Modifier,
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(items = newsList){ news ->
                Column(
                    modifier = Modifier.height(Constants.BIG_CARD_HEIGHT.dp)
                ) {
                    HeadlineHorizontalCard(news = news)
                }

            }
        }
    }
}