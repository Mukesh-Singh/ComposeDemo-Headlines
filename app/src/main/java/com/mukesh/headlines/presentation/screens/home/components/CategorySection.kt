package com.mukesh.headlines.presentation.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mukesh.headlines.presentation.common.component.HorizontalChip
import com.mukesh.module.domain.model.network.Source

/**
Created by Mukesh on 28/10/22
 **/

@Composable
fun CategorySection(
    modifier: Modifier = Modifier,
    selectedValue: Pair<String?, String?>?,
    sourceList: List<Pair<String?, String?>>,
    onCheckChanged: (checked: Boolean, value: Pair<String?, String?>) -> Unit
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(sourceList){ source ->
            HorizontalChip(
                value = source,
                selected = selectedValue?.first == source.first,
                onCheckChanged = onCheckChanged
            )
        }
    }
}