package com.hfad.popularlibrariesrxjava2dagger2moxy.model

import com.hfad.popularlibrariesrxjava2dagger2moxy.model.api.ApiFactory
import com.hfad.popularlibrariesrxjava2dagger2moxy.utils.schedulers.SchedulersFactory


object RepositoryFactory {
    fun create(): GithubUsersRepo =
        RetrofitGithubUsersRepoImpl(ApiFactory.api, SchedulersFactory.create())
}