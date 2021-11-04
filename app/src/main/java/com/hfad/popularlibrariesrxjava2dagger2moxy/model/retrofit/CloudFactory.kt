package com.hfad.popularlibrariesrxjava2dagger2moxy.model.retrofit

import com.hfad.popularlibrariesrxjava2dagger2moxy.model.api.ApiFactory
import com.hfad.popularlibrariesrxjava2dagger2moxy.utils.schedulers.SchedulersFactory

object CloudFactory {
    fun create(): CloudSource =
        RetrofitGithubUsersRepoImpl(ApiFactory.api, SchedulersFactory.create())
}