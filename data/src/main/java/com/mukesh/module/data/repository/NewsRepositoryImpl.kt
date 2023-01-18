package com.mukesh.module.data.repository


import android.util.Log
import com.mukesh.module.data.exceptions.APIConnectivityException
import com.mukesh.module.data.repository.datasource.NewsRemoteDataSource
import com.mukesh.module.domain.model.network.News
import com.mukesh.module.domain.model.network.NewsApiResponse
import com.mukesh.module.domain.model.network.Source
import com.mukesh.module.domain.model.network.SourceResponse
import com.mukesh.module.domain.repository.NewsRepository
import com.mukesh.module.domain.util.Result
import com.mukesh.module.domain.util.Exception
import retrofit2.Response

/**
Created by Mukesh on
 **/

class NewsRepositoryImpl(
    //private val localDataSource: NewsLocalDataSource,
    private val remoteDataSource: NewsRemoteDataSource
): NewsRepository {
    override suspend fun getHeadlines(queryMap: Map<String, String>): Result<List<News>> {
        val response: Response<NewsApiResponse> = remoteDataSource.getHeadlines(queryMap)
        var result: Result<List<News>>? = null
        validateResponse<NewsApiResponse, List<News>>(
            response = response,
            onValidResponse = {newsApiResponse: NewsApiResponse ->
                result = Result.Success(newsApiResponse.articles)
            },
            onError = { error ->
                result = error
            }
        )
        return result!!
    }

    override suspend fun getSources(): Result<List<Source>> {
        val response: Response<SourceResponse> = remoteDataSource.getSources()
        var result: Result<List<Source>>? = null
        validateResponse<SourceResponse, List<Source>>(
            response = response,
            onValidResponse = {sourceResponse: SourceResponse ->
                result = Result.Success(sourceResponse.sources)
            },
            onError = { error ->
                result = error
            }
        )
        return result!!
    }

    private fun <InResponseType, OutResponseType> validateResponse(response: Response<InResponseType>, onValidResponse: (response: InResponseType) -> Unit, onError: (error: Result<OutResponseType>) -> Unit ){
        try {
            if(response.isSuccessful){
                response.body()?.let {result->
                    onValidResponse(result)
                    return
                }
            }
            Log.e("NewsRepositoryImpl", response.message() ?: "Something went wrong")
            onError(Result.Error(Exception.ApiException(response.code(), response.message())))
            return
        }catch (e: kotlin.Exception){
            Log.e("NewsRepositoryImpl", e.message ?: "Something went wrong")
            if (e is APIConnectivityException) {
                onError(Result.Error(Exception.ApiException(APIConnectivityException.CODE, e.message)))
                return
            }
            onError (Result.Error(Exception.ApiException(Exception.UNKNOWN_EXCEPTION_CODE, e.message)))
            return
        }
    }

}