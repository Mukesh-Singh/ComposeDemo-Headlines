package com.mukesh.module.domain.repository

import com.mukesh.module.domain.model.network.News
import com.mukesh.module.domain.model.network.Source
import com.mukesh.module.domain.util.Result

/**
Created by Mukesh on 17/10/22
 **/

interface NewsRepository {
    suspend fun getHeadlines(queryMap: Map<String, String>): Result<List<News>>
    suspend fun getSources (): Result<List<Source>>
}