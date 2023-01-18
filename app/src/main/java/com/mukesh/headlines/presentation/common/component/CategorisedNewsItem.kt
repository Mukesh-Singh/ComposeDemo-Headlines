package com.mukesh.headlines.presentation.common.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.mukesh.headlines.R
import com.mukesh.headlines.presentation.util.Constants
import com.mukesh.headlines.ui.theme.CustomFont
import com.mukesh.headlines.ui.theme.HeadlinesTheme
import com.mukesh.module.domain.model.network.News

/**
Created by Mukesh on 21/10/22
 **/

@OptIn(ExperimentalUnitApi::class)
@Composable
fun CategorisedNewsItem(modifier: Modifier = Modifier, news : News) {
    var hasErrorInImageLoading by remember{ mutableStateOf(false) }
    if (news.urlToImage.isNullOrBlank()){
        hasErrorInImageLoading = true
    }
    Column(
        modifier= modifier.padding(top = 0.dp),
        //verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        Column() {
            if (!hasErrorInImageLoading) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(height = Constants.NEWS_ITEM_IMAGE_HEIGHT.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    painter = rememberAsyncImagePainter(
                        model = news.urlToImage,
                        placeholder = painterResource(id = R.drawable.placeholder),
                        onError = {
                            hasErrorInImageLoading = true
                        }
                    ),
                    contentDescription = "Place Holder",
                    contentScale = ContentScale.Crop,
                )
            }
            SourceAndTime(
                modifier = Modifier.padding(top = if(hasErrorInImageLoading) 0.dp else 16.dp).fillMaxWidth(),
                publishedAtDate = news.getPublishedDateWithDay(),
                sourceName = news.source?.name,
//                tagStyle = MaterialTheme.typography.overline.toSpanStyle().copy(
//                    background = MaterialTheme.colors.onSurface.copy(alpha = 0.5f),
//                    color = Color.White.copy(
//                        alpha = 1.0f
//                    )
//                ),
                textStyle = CustomFont.NunitoSemiboldSmall.copy(
                    fontSize = TextUnit(10.0f, TextUnitType.Sp),
                    color = MaterialTheme.colors.onSurface
                )
            )


            Text(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                text = news.title?:"",
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                style = CustomFont.NewYourSemiBold

            )

            news.description?.let {
                Text(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(),
                    text = it,
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis,
                    style = CustomFont.NunitoRegularMedium

                )
            }

            Text(
                modifier = Modifier
                    .padding(top = if (news.description.isNullOrBlank())8.dp else 12.dp)
                    .fillMaxWidth(),
                text = stringResource(id = R.string.published_by, news.author?:""),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = CustomFont.NunitoBoldSmall.copy(
                    fontWeight = FontWeight.Black,
                    color = MaterialTheme.colors.onSurface
                )

            )

        }

    }
}

@Preview (showBackground = true)
@Composable
fun Preview_CategorisedNewsItem() {
    HeadlinesTheme {
        CategorisedNewsItem(news = News.getSampleNews())
    }
}