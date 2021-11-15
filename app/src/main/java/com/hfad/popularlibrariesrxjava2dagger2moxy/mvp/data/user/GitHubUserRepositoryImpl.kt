package com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.data.user

class GitHubUserRepositoryImpl : GitHubUserRepository {

    private val repositories = listOf(
        GitHubUser("login1"),
        GitHubUser("login2"),
        GitHubUser("login3"),
        GitHubUser("login4"),
        GitHubUser("login5")
    )

    override fun getUsers(): List<GitHubUser> {
        return repositories
    }


}