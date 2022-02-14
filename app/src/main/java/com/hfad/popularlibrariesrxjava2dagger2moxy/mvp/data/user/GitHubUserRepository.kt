package com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.data.user

import io.reactivex.rxjava3.core.Single

interface GitHubUserRepository {

    fun getUsers(): Single<List<GitHubUser>>
}