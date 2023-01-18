package com.mukesh.headlines.presentation.screens.home.components.shimmer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mukesh.headlines.presentation.common.component.ChipShimmer

/**
Created by Mukesh on 21/10/22
 **/

@Composable
fun ChipShimmerSection(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(5){
            ChipShimmer()
        }
    }

}