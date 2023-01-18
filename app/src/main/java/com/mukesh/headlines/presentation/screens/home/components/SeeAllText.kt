package com.mukesh.headlines.presentation.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mukesh.headlines.R
import com.mukesh.headlines.ui.theme.ContentColor
import com.mukesh.headlines.ui.theme.CustomFont
import com.mukesh.headlines.ui.theme.HeadlinesTheme

/**
Created by Mukesh on 20/10/22
 **/

@Composable
fun SeeAllText(
    modifier: Modifier = Modifier,
    onClick : () -> Unit
) {
    Row(
        modifier = modifier
            .height(20.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(
                    bounded = false,
                )
            ){
             onClick()
            }
        ,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Text(
            modifier = modifier,
            text = stringResource(id = R.string.see_all),
            style = CustomFont.NunitoSemiboldSmall.copy(
                color = ContentColor.BlueTextColor
            ),
        )
        Icon(
            modifier = Modifier.padding(start = 4.dp),
            imageVector = Icons.Default.ArrowForward,
            contentDescription ="See All",
            tint = ContentColor.BlueTextColor
        )
    }

}

@Preview(showBackground = true)
@Composable
fun Preview_SeeAllText() {
    HeadlinesTheme {
        SeeAllText(onClick = {})
    }
}