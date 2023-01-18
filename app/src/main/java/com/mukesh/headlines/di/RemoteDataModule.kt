package com.mukesh.headlines.di


import com.mukesh.module.data.api.NewsApi
import com.mukesh.module.data.repository.datasource.NewsRemoteDataSource
import com.mukesh.module.data.repository.datasourceImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
Created by Mukesh on 19/10/22
 **/

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {
    @Provides
    fun provideNewsRemoteDataSource(newsApi: NewsApi) : NewsRemoteDataSource =
        NewsRemoteDataSourceImpl(newsApi)
}