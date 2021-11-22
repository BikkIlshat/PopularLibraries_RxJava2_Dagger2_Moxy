package com.hfad.popularlibrariesrxjava2dagger2moxy.data.user

object GitHubUserRepositoryFactory {

    fun create(): GitHubUserRepository = GitHubUserRepositoryImpl()
}

