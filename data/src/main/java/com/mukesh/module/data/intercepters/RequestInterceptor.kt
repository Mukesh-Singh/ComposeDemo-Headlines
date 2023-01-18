package com.mukesh.module.data.intercepters

import com.mukesh.module.data.exceptions.APIConnectivityException
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
Created by Mukesh on 21/10/22
 **/

class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder: Request.Builder = chain.request().newBuilder()
        try {
            return chain.proceed(builder.build())
        } catch (e: Exception) {
            e.printStackTrace()
            throw APIConnectivityException("Api connectivity error!", e)
        }
    }
}