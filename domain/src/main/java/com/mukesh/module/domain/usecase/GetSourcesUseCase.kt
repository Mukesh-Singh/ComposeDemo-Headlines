package com.mukesh.module.domain.usecase

import com.mukesh.module.domain.model.network.Source
import com.mukesh.module.domain.repository.NewsRepository
import com.mukesh.module.domain.util.Result

/**
Created by Mukesh on 28/10/22
 **/

class GetSourcesUseCase(private val newsRepository: NewsRepository) {
    private var apiResponse: Result<List<Source>>? = null
    suspend operator fun invoke(): Result<List<Source>>{
        apiResponse = newsRepository.getSources()
        return apiResponse!!

    }

    fun getCategoryList(): Result<List<Pair<String?, String?>>>  {
        if (apiResponse is Result.Success){
            val sourceList = (apiResponse as Result.Success<List<Source>>).data
            val categoryList = arrayListOf<Pair<String?, String?>>()
            val set: MutableSet<String?> = hashSetOf()
            sourceList?.map {
                if (!set.contains(it.category)) {
                    set.add(it.category)
                    categoryList.add(Pair(it.category, it.getCategoryName()))
                }
            }
            return if (categoryList.isEmpty()){
                Result.Error(Throwable("No Data Found"))
            } else{
                Result.Success(categoryList)
            }
        }
        else{
            return Result.Error(Throwable("No Data Found"))

        }
    }
}