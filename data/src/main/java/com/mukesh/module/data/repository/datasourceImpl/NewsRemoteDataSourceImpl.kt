package com.mukesh.module.data.repository.datasourceImpl

import com.mukesh.module.data.api.NewsApi
import com.mukesh.module.data.repository.datasource.NewsRemoteDataSource
import com.mukesh.module.domain.model.network.NewsApiResponse
import com.mukesh.module.domain.model.network.SourceResponse
import retrofit2.Response

/**
Created by Mukesh on 18/10/22
 **/

class NewsRemoteDataSourceImpl(private val newsApi: NewsApi): NewsRemoteDataSource {
    override suspend fun getHeadlines(queryMap: Map<String, String>): Response<NewsApiResponse> {
        return newsApi.getHeadline(queryMap = queryMap)
    }

    override suspend fun getSources(): Response<SourceResponse> {
        return newsApi.getSources()
    }
}