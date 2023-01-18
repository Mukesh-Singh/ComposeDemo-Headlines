package com.mukesh.headlines.presentation.common.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import coil.compose.rememberAsyncImagePainter
import com.mukesh.headlines.R
import com.mukesh.headlines.presentation.util.Constants
import com.mukesh.headlines.ui.theme.CustomFont
import com.mukesh.headlines.ui.theme.HeadlinesTheme
import com.mukesh.module.domain.model.network.News
import com.valentinilk.shimmer.shimmer
import java.util.*

/**
Created by Mukesh on 20/10/22
 **/

@Composable
fun HeadlineHorizontalCard(
    modifier: Modifier = Modifier,
    news: News
) {
    Card(
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
                .fillMaxWidth(),
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(12.dp))
                    .drawWithCache {
                        val gradient = Brush.verticalGradient(
                            colors = listOf(
                                Color.Black.copy(alpha = 0.3f), Color.Black.copy(
                                    alpha = 0.8f
                                )
                            ),
                            startY = 0.0f,
                            endY = size.height
                        )
                        onDrawWithContent {
                            drawContent()
                            drawRect(gradient, blendMode = BlendMode.Multiply)
                        }
                    },
                painter = rememberAsyncImagePainter(
                    model = news.urlToImage,
                    placeholder = painterResource(id = R.drawable.placeholder)

                ),
                contentDescription = "Place Holder",
                contentScale = ContentScale.Crop,
            )
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp),
                verticalArrangement = Arrangement.Top) {
                SourceAndTime(
                    modifier = modifier.padding(top = 16.dp, bottom = 16.dp),
                    publishedAtDate = news.getPublishedDate(),
                    publishedAtTime = news.getPublishedTime(),
                    sourceName = news.source?.name
                )

            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 24.dp),
                verticalArrangement = Arrangement.Center,
                //verticalArrangement = Arrangement.spacedBy(16.dp),

            ) {
                if (!news.author.isNullOrBlank()) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = stringResource(id = R.string.by_auther_name, news.author ?: ""),
                        style = CustomFont.NunitoExtraBoldSmall.copy(
                            color = Color.White
                        )
                    )
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    text = news.title ?: "",
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis,
                    style = CustomFont.NewYourBold.copy(
                        color = Color.White
                    )
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 16.dp),
                verticalArrangement = Arrangement.Bottom,

                ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = news.description ?: "",
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = CustomFont.NunitoSemiboldSmall.copy(
                        color = Color.White
                    )


                )

            }
        }
    }
}



@Preview()
@Composable
fun Preview_HeadlineHorizontalCard() {
    HeadlinesTheme {
        HeadlineHorizontalCard(news = News.getSampleNews())
    }
}

