package com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.data.user

interface GitHubUserRepository {

    fun getUsers() : List<GitHubUser>
}