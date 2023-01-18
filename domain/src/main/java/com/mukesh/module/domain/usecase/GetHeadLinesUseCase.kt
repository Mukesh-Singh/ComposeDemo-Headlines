package com.mukesh.module.domain.usecase

import com.mukesh.module.domain.repository.NewsRepository

/**
Created by Mukesh on 18/10/22
 **/

class GetHeadLinesUseCase(private val newsRepository: NewsRepository) {
    suspend operator fun invoke(queryMap: Map<String, String>) = newsRepository.getHeadlines(queryMap)
}