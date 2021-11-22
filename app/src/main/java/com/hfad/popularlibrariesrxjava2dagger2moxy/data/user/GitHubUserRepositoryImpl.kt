package com.hfad.popularlibrariesrxjava2dagger2moxy.data.user

import com.hfad.popularlibrariesrxjava2dagger2moxy.data.api.GitHubApi
import com.hfad.popularlibrariesrxjava2dagger2moxy.data.api.GitHubApiFactory
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import java.io.IOException
import java.lang.RuntimeException

class GitHubUserRepositoryImpl(
    private val gitHubApi: GitHubApi = GitHubApiFactory.create()
) : GitHubUserRepository {

    override fun getUsers(): Single<List<GitHubUser>> =
        gitHubApi
            .fetchUsers()
            .onErrorResumeNext { error ->
                when(error) {
                    is IOException -> Single.error(RuntimeException("нет соединения с сетью"))
                    else -> Single.error(error)
                }
            }

    override fun getUserByLogin(login: String): Maybe<GitHubUser> =
        gitHubApi
            .fetchUserByLogin(login)
            .onErrorComplete()// если будет ошибка, вернёт Maybe Empty

    override fun getUserRepositories(url: String):
            Maybe<List<GitHubUserUserRepositories>> =
        gitHubApi.fetchUserRepositories(url).toMaybe()
}