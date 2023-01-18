package com.mukesh.headlines.presentation.screens.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mukesh.module.domain.model.network.News
import com.mukesh.module.domain.model.network.Source
import com.mukesh.module.domain.usecase.HomeScreenUseCases
import com.mukesh.module.domain.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
Created by Mukesh on 18/10/22
 **/

@HiltViewModel
class HomeViewModel  @Inject constructor(
    private val homeScreenUseCases: HomeScreenUseCases
): ViewModel(){
    private val queryMap : HashMap<String, String> = HashMap<String, String> ()
    private val _headlineState = mutableStateOf<Result<List<News>>>(Result.Loading())
    val headlineState: State<Result<List<News>>> = _headlineState
    private val _sourcesState = mutableStateOf<Result<List<Source>>>(Result.Loading())
    val sourceState : State<Result<List<Source>>> = _sourcesState
    private val _categoriesState = mutableStateOf<Result<List<Pair<String?, String?>>>>(Result.Loading())
    val categoriesState : State<Result<List<Pair<String?, String?>>>> = _categoriesState
    val selectedCategoryState = mutableStateOf<Pair<String?, String?>?> (null)

    private val _categoriesHeadlineState = mutableStateOf<Result<List<News>>>(Result.Loading())
    val categoriesHeadlineState: State<Result<List<News>>> = _categoriesHeadlineState

    init {
        queryMap["country"] = "in"
        getHeadlines()
        getSources()
        snapshotFlow {selectedCategoryState.value}
            .onEach {
            //Call news list api with new value
            Log.d("HomeViewModel", "Selected item id ${it?.first} and value ${it?.second}" )
                it?.first?.let { nonNullId->
                    getCategorisedHeadline(nonNullId)
                }
        }.launchIn(viewModelScope)
    }

    private fun getSources() {
        viewModelScope.launch {
            //todo this delay is just to show shimmer for longer time on UI
            delay(2000)
            _sourcesState.value = homeScreenUseCases.getSourcesUseCase()
            val categoryList = homeScreenUseCases.getSourcesUseCase.getCategoryList()
            _categoriesState.value = categoryList

        }
    }

    private fun getHeadlines() {
        viewModelScope.launch {
            //todo this delay is just to show shimmer for longer time on UI
            delay(2000)
            _headlineState.value =  homeScreenUseCases.getHeadLinesUseCase(queryMap)
        }
    }

    private fun getCategorisedHeadline(categoryId: String) {
        val queryMap: HashMap<String, String> =  hashMapOf()
        queryMap["category"] = categoryId
        queryMap["country"] = "in"
        _categoriesHeadlineState.value = Result.Loading()
        viewModelScope.launch {
            _categoriesHeadlineState.value =  homeScreenUseCases.getHeadLinesUseCase(queryMap)
        }
    }


}