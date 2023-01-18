package com.mukesh.module.domain.util

/**
Created by Mukesh on 17/10/22
 **/

sealed class Result<out T>{
    class Loading<out T> : Result<T>()
    class Success<out T>(val data: T? = null) : Result<T>()
    class Error<out T>(val error: Throwable? = null) : Result<T>()
}


sealed class Exception(override val message: String? = null, override val cause: Throwable? = null): Throwable(message,cause) {
    companion object{
        const val UNKNOWN_EXCEPTION_CODE = 1000
    }
    class ApiException(val responseCode: Int?, override val message: String?) : Exception(message)
}

