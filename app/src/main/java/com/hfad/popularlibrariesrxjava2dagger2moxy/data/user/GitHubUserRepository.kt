package com.hfad.popularlibrariesrxjava2dagger2moxy.data.user

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single


interface GitHubUserRepository {

    fun getUsers(): Single<List<GitHubUser>>
    fun getUserByLogin(login: String): Maybe<GitHubUser>
    fun getUserRepositories(url: String): Maybe<List<GitHubUserUserRepositories>>

}