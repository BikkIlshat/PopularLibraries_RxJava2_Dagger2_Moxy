package com.hfad.popularlibrariesrxjava2dagger2moxy.model.api

import com.hfad.popularlibrariesrxjava2dagger2moxy.BuildConfig.GITHUB_USER_NAME
import com.hfad.popularlibrariesrxjava2dagger2moxy.BuildConfig.GITHUB_USER_PASSWORD
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor

object GithubInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        request.newBuilder()
            .header("Authorization", Credentials.basic(GITHUB_USER_NAME, GITHUB_USER_PASSWORD))
            .build().apply {
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            }
        return chain.proceed(request)
    }
}