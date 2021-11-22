package com.hfad.popularlibrariesrxjava2dagger2moxy.data.api

import com.hfad.popularlibrariesrxjava2dagger2moxy.data.user.GitHubUser
import com.hfad.popularlibrariesrxjava2dagger2moxy.data.user.GitHubUserUserRepositories
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

/**
 * Описываются методы, посредством которых будут загружаться данные для точки входа (https://api.github.com/),
 * затем по этому описанию автоматически генерируется экземпляр класса Retrofit, реализующий этот интерфейс
 */
interface GitHubApi {

    @GET("/users")
    fun fetchUsers(@Query("since") since: Int? = null): Single<List<GitHubUser>>

    @GET("/users/{username}")
    fun fetchUserByLogin(@Path("username") login: String): Single<GitHubUser>

    @GET
    fun fetchUserRepositories(@Url url: String): Single<List<GitHubUserUserRepositories>>
}