package com.mukesh.module.data.repository.datasource

import com.mukesh.module.domain.model.network.NewsApiResponse
import com.mukesh.module.domain.model.network.SourceResponse
import retrofit2.Response

/**
Created by Mukesh on 18/10/22
 **/

interface NewsRemoteDataSource {
    suspend fun getHeadlines(queryMap: Map<String, String>): Response<NewsApiResponse>
    suspend fun getSources(): Response<SourceResponse>
}