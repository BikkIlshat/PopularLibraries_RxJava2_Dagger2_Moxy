package com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.data.user

import io.reactivex.rxjava3.core.Single

class GitHubUserRepositoryImpl : GitHubUserRepository {

    private val repositories = listOf(
        GitHubUser("login1"),
        GitHubUser("login2"),
        GitHubUser("login3"),
        GitHubUser("login4"),
        GitHubUser("login5")
    )

    override fun getUsers(): Single<List<GitHubUser>> =
        Single.just(repositories)



}