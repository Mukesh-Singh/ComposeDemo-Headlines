package com.mukesh.headlines.presentation.common.component

import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import com.mukesh.headlines.ui.theme.CustomFont
import com.mukesh.headlines.ui.theme.HeadlinesTheme
import com.mukesh.module.domain.model.network.News

/**
Created by Mukesh on 31/10/22
 **/

@OptIn(ExperimentalUnitApi::class)
@Composable
fun SourceAndTime(
    modifier: Modifier = Modifier,
    publishedAtDate: String?,
    publishedAtTime: String? = null,
    sourceName: String?,
    divider: String = "  •  ",
    tagStyle: SpanStyle = MaterialTheme.typography.overline.toSpanStyle().copy(
        background = MaterialTheme.colors.secondary.copy(alpha = 1.0f),
        color = MaterialTheme.colors.onSecondary.copy(
            alpha = 1.0f
        )
    ),
    textStyle: TextStyle = CustomFont.NunitoSemiboldSmall.copy(
        fontSize = TextUnit(10.0f, TextUnitType.Sp),
        color = Color.White
    )
) {
    val text = buildAnnotatedString {
        sourceName?.let {nonNullSourceName ->
            withStyle(tagStyle) {
                append(" $nonNullSourceName ")
            }
            append(divider)
        }
        publishedAtTime?.let {
            append(it)
            if (publishedAtDate!=null){
                append(divider)
            }
        }
        //append(divider)
        publishedAtDate?.let { append(it) }

    }
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
        Text(
            text = text,
            modifier = modifier,
            style = textStyle
        )
    }

}

@Preview()
@Composable
fun Preview_SourceAndTime() {
    HeadlinesTheme {
        HeadlineHorizontalCard(news = News.getSampleNews())
    }
}