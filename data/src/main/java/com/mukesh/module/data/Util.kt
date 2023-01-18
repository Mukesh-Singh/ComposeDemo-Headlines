package com.mukesh.module.data

import retrofit2.Response
import com.mukesh.module.domain.util.Result

/**
Created by Mukesh on 18/10/22
 **/

//internal fun <T> responseToRequest(response: Response<T>): Result<T>{
//    if(response.isSuccessful){
//        response.body()?.let {result->
//            return Result.Success(result)
//        }
//    }
//    return Result.Error(Error.ApiError(response.message()).errorObject)
//}