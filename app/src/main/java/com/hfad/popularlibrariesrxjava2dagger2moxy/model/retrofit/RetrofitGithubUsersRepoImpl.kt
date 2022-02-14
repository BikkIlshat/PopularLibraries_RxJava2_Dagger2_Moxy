package com.hfad.popularlibrariesrxjava2dagger2moxy.model.retrofit

import com.hfad.popularlibrariesrxjava2dagger2moxy.model.api.ServiceApi
import com.hfad.popularlibrariesrxjava2dagger2moxy.utils.schedulers.Schedulers
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject


class RetrofitGithubUsersRepoImpl
@Inject constructor(
    private val api: ServiceApi,
    private val schedulers: Schedulers
) : CloudSource {

    override fun getUsers(): Single<List<GithubUser>> =
        api.getUsers()
            .subscribeOn(schedulers.background())


    override fun getRepos(url: String?): Single<List<GithubRepos>> =
        api.getRepos(url)
            .subscribeOn(schedulers.background())

    override fun getRepo(url: String?): Single<GithubRepos> = api
        .getRepo(url)
        .subscribeOn(schedulers.background())
}