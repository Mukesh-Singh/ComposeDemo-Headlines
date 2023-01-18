package com.mukesh.headlines.di


import com.mukesh.module.domain.repository.NewsRepository
import com.mukesh.module.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
/**
Created by Mukesh on 19/10/22
 **/

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideHomeScreenUseCases(newsRepository: NewsRepository) = HomeScreenUseCases(
        getHeadLinesUseCase =  GetHeadLinesUseCase(newsRepository = newsRepository),
        getSourcesUseCase = GetSourcesUseCase(newsRepository = newsRepository)
    )

    @Provides
    fun provideHomeActivityUseCases() = HomeActivityUseCase(
        greetingUseCase = GreetingUseCase()
    )
}