package com.hfad.popularlibrariesrxjava2dagger2moxy.model.api

import com.hfad.popularlibrariesrxjava2dagger2moxy.model.GithubRepos
import com.hfad.popularlibrariesrxjava2dagger2moxy.model.GithubUser
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface ServiceApi {
    @GET("/users")
    fun getUsers(): Single<List<GithubUser>>

    @GET
    fun getRepos(@Url url: String?): Single<List<GithubRepos>>

    @GET
    fun getRepo(@Url url: String?): Single<GithubRepos>
}