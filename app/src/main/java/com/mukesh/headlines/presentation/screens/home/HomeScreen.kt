package com.mukesh.headlines.presentation.screens.home


import android.util.Log
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mukesh.headlines.R
import com.mukesh.headlines.SharedViewModel
import com.mukesh.headlines.presentation.common.component.AppHeader
import com.mukesh.headlines.presentation.common.component.CategorisedNewsItem
import com.mukesh.headlines.presentation.common.component.CategorisedNewsItemShimmer
import com.mukesh.headlines.presentation.common.component.SectionHeader
import com.mukesh.headlines.presentation.models.OptionMenuItem
import com.mukesh.headlines.presentation.rout.Rout
import com.mukesh.headlines.presentation.screens.home.components.*
import com.mukesh.headlines.presentation.screens.home.components.shimmer.ChipShimmerSection
import com.mukesh.headlines.presentation.screens.home.components.shimmer.NewsItemsShimmerWithStyleWraper
import com.mukesh.headlines.presentation.screens.home.components.shimmer.TopHeadlineShimmer
import com.mukesh.module.domain.model.network.News
import com.mukesh.module.domain.util.Result
import kotlinx.coroutines.launch

/**
Created by Mukesh on 18/10/22
 **/

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController? = null,
    sharedViewModel: SharedViewModel? = null,
){
    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = {
            it != ModalBottomSheetValue.HalfExpanded
        }
    )
    val coroutineScope = rememberCoroutineScope()
    var bottomSheetType by remember{ mutableStateOf(1) }

    BackHandler(sheetState.isVisible) {
        coroutineScope.launch { sheetState.hide() }
    }

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = {
            HomeScreenBottomSheet("BottomSheet", bottomSheetType, sharedViewModel = sharedViewModel)
        },
        sheetShape = RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp, bottomStart = 0.dp, bottomEnd = 0.dp),
        modifier = Modifier.fillMaxSize(),
    ) {
        Scaffold( modifier = modifier,
            topBar = {
                AppHeader(
                    title = stringResource(id = R.string.greeting,sharedViewModel?.greetingState?.value?:""),
                    navController = navController,
                    optionMenuList = listOf(OptionMenuItem.Setting),
                    onMenuItemSelect ={item, label ->
                        Log.e("Action", "Option item clicked ${label}")
                        bottomSheetType = item.id
                        coroutineScope.launch {
                                if (sheetState.isVisible) sheetState.hide()
                                else sheetState.show()
                        }
                    }
                )
            },
            floatingActionButton = {
                    FloatingActionButton(
                        onClick = {
                            Log.e("Filter", "Filter icon clicked")
                        },
                        backgroundColor = MaterialTheme.colors.primary,
                        content = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_filter),
                                contentDescription = null,
                                tint = MaterialTheme.colors.onPrimary
                            )
                        }
                    )
            },
            floatingActionButtonPosition = FabPosition.End,


            ) { innerPadding ->
            Surface(
                modifier = Modifier
                    .padding(paddingValues = innerPadding)
                    .fillMaxSize(),
                //color = MaterialTheme.colors.background
            ) {
                HomeScreenContent(navController = navController, sharedViewModel = sharedViewModel)
                //SettingBottomSheet(sheetState = sheetState, text = "Text $bottomSheetType")
            }
        }
    }



}

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    navController: NavController? = null,
    sharedViewModel: SharedViewModel? = null,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val topHeadLine by remember {
        viewModel.headlineState
    }
    val categories by remember {
        viewModel.categoriesState
    }
    val categorisedHeadlines by remember {
        viewModel.categoriesHeadlineState
    }
    LazyColumn(
        modifier = modifier,
        //.padding(vertical = 24.dp)
        contentPadding = PaddingValues(vertical = 16.dp)
    )
    {
        item {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                ,
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                SectionHeader(
                    modifier = Modifier
                        .padding(start = 8.dp),

                    )
                SeeAllText(
                    modifier = Modifier
                        .padding(end = 8.dp),
                    onClick = {
                        if (topHeadLine is Result.Success){
                            sharedViewModel?.setViewAllTopHeadlinesData((topHeadLine as Result.Success<List<News>>).data)
                            navController?.navigate(Rout.HEADLINE_VIEW_ALL.rout)
                        }

                    }
                )
            }
        }
        item {
            when (topHeadLine) {
                is Result.Loading-> {
                    Log.e("Loading", "Loading.....Topheadline")
                    TopHeadlineShimmer(modifier = Modifier.padding(top= 16.dp))
                }
                is Result.Success -> {
                    val size = (topHeadLine as Result.Success<List<News>>).data?.size?:0
                    //Log.e("Success", "TopHeadline items count $size")
                    (topHeadLine as Result.Success<List<News>>).data?.let { TopHeadlineHorizontalSection(modifier = Modifier.padding(top= 16.dp),newsList = it) }
                }
                is Result.Error -> {
                    Log.e("Error", (topHeadLine as Result.Error<List<News>>).error?.message ?: "Something went wrong")
                    Toast.makeText(
                        LocalContext.current,
                        (topHeadLine as Result.Error<List<News>>).error?.message ?: "Something went wrong",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
        item {
            when (categories) {
                is Result.Loading->{
                    Log.e("Loading", "Loading.....Chips")
                    ChipShimmerSection(
                        modifier = Modifier.padding(top = 32.dp)
                    )
                }
                is Result.Success ->{
                    val sourceCategoryResponse = categories as Result.Success<List<Pair<String?, String?>>>
                    //Log.e("Success", "Category chip items count ${sourceCategoryResponse.data?.size}")
                    val selectedItem by rememberSaveable {viewModel.selectedCategoryState}
                    sourceCategoryResponse.data?.let {
                        if (selectedItem == null){
                            viewModel.selectedCategoryState.value = it.getOrNull(0)
                        }
                        CategorySection(
                            modifier = Modifier.padding(top = 32.dp),
                            sourceList = it,
                            selectedValue = selectedItem,
                            onCheckChanged = { checked, value ->
                                Log.e("ChipClicked", "Selected $checked and item is ${value.second}")
                                if (checked)
                                    viewModel.selectedCategoryState.value = value
                                else
                                    viewModel.selectedCategoryState.value = null
                            }
                        )
                    }

                }
                is Result.Error -> {
                    val sourceCategoryResponse = (categories as Result.Error<List<Pair<String?, String?>>>)
                    Log.e("Source-Error", sourceCategoryResponse.error?.message ?: "Something went wrong")
                    Toast.makeText(
                        LocalContext.current,
                        sourceCategoryResponse.error?.message ?: "Something went wrong",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }
        item {
            Spacer(modifier = Modifier.height(32.dp))
        }
        when (categorisedHeadlines) {
            is Result.Loading->{
                Log.e("Loading", "Loading.....Categorised News")
                items(10){ index ->
                    NewsItemsShimmerWithStyleWraper(){
                        CategorisedNewsItemShimmer(modifier = Modifier.padding(horizontal = 16.dp))
                        if (index!=9)
                            Divider(
                                modifier = Modifier
                                    .padding(top = 16.dp)
                                    .height(0.5.dp)
                                ,
                                color = MaterialTheme.colors.onSurface.copy(
                                    alpha = 0.5f
                                ))
                    }
                }
            }
            is Result.Success->{
                val categorisedHeadlineResponse = (categorisedHeadlines as Result.Success<List<News>>)
                //Log.d("Success", "Categorised news itemCount ${categorisedHeadlineResponse.data?.size}")
                categorisedHeadlineResponse.data?.let {
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
            is Result.Error->{
                Log.d("Error", "Error Categorised news response")
            }
        }

    }
}





