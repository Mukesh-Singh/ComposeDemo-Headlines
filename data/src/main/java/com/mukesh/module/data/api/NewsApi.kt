package com.mukesh.module.data.api

import com.mukesh.module.data.BuildConfig
import com.mukesh.module.domain.model.network.NewsApiResponse
import com.mukesh.module.domain.model.network.SourceResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

/**
Created by Mukesh on 18/10/22
 **/

interface NewsApi {
    @GET("top-headlines")
    suspend fun getHeadline(
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY,
        @QueryMap queryMap: Map<String, String>
    ): Response<NewsApiResponse>

    @GET("top-headlines/sources")
    suspend fun getSources(
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY,
    ): Response<SourceResponse>
}