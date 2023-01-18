package com.mukesh.headlines

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import com.mukesh.module.domain.model.network.News
import com.mukesh.module.domain.usecase.HomeActivityUseCase
import com.mukesh.module.domain.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
Created by Mukesh on 31/10/22
 **/

@HiltViewModel
class SharedViewModel @Inject constructor( private val homeActivityUseClass: HomeActivityUseCase): ViewModel(){
    val ThemeList = listOf<String>("System Theme","Dark Theme", "Light Theme")
    private val _greetingState = mutableStateOf<String>(homeActivityUseClass.greetingUseCase())
    val greetingState: State<String> = _greetingState
    //View All top headline
    private val _viewAllHeadlineState = mutableStateOf<List<News>?>(null)
    val viewAllHeadlineState: State<List<News>?> = _viewAllHeadlineState
    private val _themeOption = mutableStateOf<String>("System Theme")
    val themeOption: State<String> = _themeOption

    init {

    }

    fun setViewAllTopHeadlinesData(data: List<News>?){
        _viewAllHeadlineState.value = data
    }

    fun setThemeOption(theme: String){
        _themeOption.value = theme
    }

}