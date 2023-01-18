package com.mukesh.headlines.presentation.screens.view_all

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mukesh.headlines.R
import com.mukesh.headlines.SharedViewModel
import com.mukesh.headlines.presentation.common.component.AppHeader
import com.mukesh.headlines.presentation.common.component.CategorisedNewsItem

/**
Created by Mukesh on 02/11/22
 **/

@Composable
fun ViewAllTopHeadLinesScreen(modifier: Modifier= Modifier, navController: NavController?= null, sharedViewModel: SharedViewModel?= null) {
    Scaffold( modifier = modifier,
        topBar = {
            AppHeader(
                showBack = true,
                title = stringResource(id = R.string.top_headlines),
                navController = navController
            )
        }
    ) {
        ViewAllTopHeadlineContent(modifier = Modifier, sharedViewModel = sharedViewModel)
    }
}

@Composable
fun ViewAllTopHeadlineContent(modifier: Modifier= Modifier, sharedViewModel: SharedViewModel?= null) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(vertical = 16.dp)
    ){
        val categorisedHeadlineResponse = sharedViewModel?.viewAllHeadlineState?.value
        categorisedHeadlineResponse?.let {
            items(it){news->
                CategorisedNewsItem(modifier = Modifier.padding(start = 16.dp, end = 16.dp),news = news)
                if (it.indexOf(news) != it.size-1)
                    Divider(
                        modifier = Modifier
                            .padding(
                                top = 24.dp,
                                bottom = 24.dp,/*start = 16.dp, end = 16.dp*/
                            )
                            .height(0.5.dp)
                        ,
                        color = MaterialTheme.colors.onSurface.copy(
                            alpha = 0.5f
                        ))
            }
        }
    }
}