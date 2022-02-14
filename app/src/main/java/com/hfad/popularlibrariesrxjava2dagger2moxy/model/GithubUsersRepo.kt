package com.hfad.popularlibrariesrxjava2dagger2moxy.model

import com.hfad.popularlibrariesrxjava2dagger2moxy.model.retrofit.GithubRepos
import com.hfad.popularlibrariesrxjava2dagger2moxy.model.retrofit.GithubUser
import io.reactivex.rxjava3.core.Single

interface GithubUsersRepo {
    fun getUsers(): Single<List<GithubUser>>
    fun getRepos(url: String?): Single<List<GithubRepos>>
    fun getRepo(url: String?): Single<GithubRepos>
}