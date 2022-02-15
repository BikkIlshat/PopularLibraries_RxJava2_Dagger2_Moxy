package com.hfad.popularlibrariesrxjava2dagger2moxy.model

import com.hfad.popularlibrariesrxjava2dagger2moxy.model.network.NetworkStatus
import com.hfad.popularlibrariesrxjava2dagger2moxy.model.retrofit.CloudSource
import com.hfad.popularlibrariesrxjava2dagger2moxy.model.retrofit.GithubRepos
import com.hfad.popularlibrariesrxjava2dagger2moxy.model.retrofit.GithubUser
import com.hfad.popularlibrariesrxjava2dagger2moxy.model.storage.DataSource
import com.hfad.popularlibrariesrxjava2dagger2moxy.utils.schedulers.Schedulers
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RepositoryImpl
@Inject constructor(
    private val cloud: CloudSource,
    private val dataSource: DataSource,
    private val network: NetworkStatus,
    private val schedulers: Schedulers
) : GithubUsersRepo {
    override fun getUsers(): Single<List<GithubUser>> = network
        .onLineSingle()
        .flatMap { isOnline ->
            if (isOnline) {
                cloud.getUsers().map { users ->
                    dataSource.insertUsers(users)
                    users
                }
            } else {
                dataSource.getUsers()
            }
        }.subscribeOn(schedulers.background())

    override fun getRepos(url: String?): Single<List<GithubRepos>> = network
        .onLineSingle()
        .flatMap { isOnline ->
            if (isOnline) {
                cloud.getRepos(url).map { repos ->
                    dataSource.insertGithubRepos(repos, url)
                    repos
                }
            } else {
                dataSource.getRepos(url)
            }
        }.subscribeOn(schedulers.background())

    override fun getRepo(url: String?): Single<GithubRepos> = network
        .onLineSingle()
        .flatMap { isOnline ->
            if (isOnline) {
                cloud.getRepo(url)
            } else {
                dataSource.getRepo(url)
            }
        }.subscribeOn(schedulers.background())
}