package com.mukesh.headlines.presentation.common.component

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mukesh.headlines.R
import com.mukesh.headlines.ui.theme.HeadlinesTheme

/**
Created by Mukesh on 20/10/22
 **/

@Composable
fun SectionHeader(modifier: Modifier = Modifier){
    Text(
        modifier = modifier,
        text = stringResource(id = R.string.top_headlines),
        style = MaterialTheme.typography.subtitle1

    )
}

@Preview(showBackground = true)
@Composable
fun Preview_SectionHeader() {
    HeadlinesTheme {
        SectionHeader()
    }
}