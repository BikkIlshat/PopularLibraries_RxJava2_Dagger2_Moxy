package com.hfad.popularlibrariesrxjava2dagger2moxy.model.storage

import com.hfad.popularlibrariesrxjava2dagger2moxy.model.GithubUsersRepo
import com.hfad.popularlibrariesrxjava2dagger2moxy.model.retrofit.GithubRepos
import com.hfad.popularlibrariesrxjava2dagger2moxy.model.retrofit.GithubUser

interface Storage : GithubUsersRepo {
    fun insertUsers(users: List<GithubUser>)
    fun insertGithubRepos(repos: List<GithubRepos>, usersUrl: String?)
}