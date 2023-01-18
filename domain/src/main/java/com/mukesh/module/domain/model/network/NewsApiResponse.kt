package com.mukesh.module.domain.model.network

/**
Created by Mukesh on 18/10/22
 **/

data class NewsApiResponse(
    val status: String? = null,
    val totalResults: Int = 0,
    val articles: List<News>? = null
)
