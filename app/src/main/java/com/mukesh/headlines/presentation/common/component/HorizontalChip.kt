package com.mukesh.headlines.presentation.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mukesh.headlines.ui.theme.CustomFont
import com.mukesh.headlines.ui.theme.HeadlinesTheme

/**
Created by Mukesh on 28/10/22
 **/

@Composable
fun HorizontalChip(
    modifier: Modifier = Modifier,
    selected: Boolean,
    value: Pair<String?, String?>,
    onCheckChanged: (checked: Boolean, value: Pair<String?, String?>) -> Unit
) {
    val borderColor = if (selected) MaterialTheme.colors.primary.copy(alpha = 0.5f) else MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
    val chipBackgroundColor =  if (selected) MaterialTheme.colors.primary else MaterialTheme.colors.surface
    val chipTextColor = if (selected) MaterialTheme.colors.onPrimary else MaterialTheme.colors.onSurface
    Column(modifier = modifier
        //.padding(4.dp)
        .wrapContentSize(Alignment.Center)
        .clip(shape = RoundedCornerShape(32.dp)),
    ) {
        Box(
            modifier = Modifier
                .border(width = 0.5f.dp, color = borderColor, shape = RoundedCornerShape(16.dp))
                .clickable(onClick = {
                    //checked = !checked
                    onCheckChanged(!selected, value)
                }) /*question = "3 Bananas required"*/
                .background(color = chipBackgroundColor )
            ,
            contentAlignment = Alignment.Center,

        ) {
            Text(
                text = value.second?:"",
                modifier = Modifier
                    .padding(8.dp)
                    //.heightIn(min = 32.dp)
                    .widthIn(min = 100.dp),
                maxLines = 1,
                textAlign = TextAlign.Center,
                style = CustomFont.NunitoSemiboldSmall.copy(
                    color = chipTextColor
                ),
            )
        }
    }
}


@Preview
@Composable
fun Preview_HorizontalChip() {
    HeadlinesTheme {
        HorizontalChip(selected = true, value = Pair("entertainment", "Entertainment"), onCheckChanged = {
            _, _, ->
        })
    }
}