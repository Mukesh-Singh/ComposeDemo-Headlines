package com.mukesh.headlines.di

import com.mukesh.module.data.repository.NewsRepositoryImpl
import com.mukesh.module.data.repository.datasource.NewsLocalDataSource
import com.mukesh.module.data.repository.datasource.NewsRemoteDataSource
import com.mukesh.module.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
Created by Mukesh on 19/10/22
 **/

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideNewsRepository(
        newsRemoteDataSource: NewsRemoteDataSource,
        //newsLocalDataSource: NewsLocalDataSource
    ): NewsRepository =
        NewsRepositoryImpl(newsRemoteDataSource)
}