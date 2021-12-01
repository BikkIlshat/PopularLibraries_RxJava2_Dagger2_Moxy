package com.hfad.popularlibrariesrxjava2dagger2moxy.di.modules

import com.hfad.popularlibrariesrxjava2dagger2moxy.model.GithubUsersRepo
import com.hfad.popularlibrariesrxjava2dagger2moxy.model.RepositoryImpl
import com.hfad.popularlibrariesrxjava2dagger2moxy.model.network.AndroidNetworkStatus
import com.hfad.popularlibrariesrxjava2dagger2moxy.model.network.NetworkStatus
import com.hfad.popularlibrariesrxjava2dagger2moxy.model.retrofit.CloudSource
import com.hfad.popularlibrariesrxjava2dagger2moxy.model.retrofit.RetrofitGithubUsersRepoImpl
import com.hfad.popularlibrariesrxjava2dagger2moxy.model.storage.DataSource
import com.hfad.popularlibrariesrxjava2dagger2moxy.model.storage.RoomRepositoryImpl
import com.hfad.popularlibrariesrxjava2dagger2moxy.ui.MainActivity
import com.hfad.popularlibrariesrxjava2dagger2moxy.ui.RepoFragment
import com.hfad.popularlibrariesrxjava2dagger2moxy.ui.UserFragment
import com.hfad.popularlibrariesrxjava2dagger2moxy.ui.UsersListFragment
import com.hfad.popularlibrariesrxjava2dagger2moxy.utils.schedulers.DefaultSchedulers
import com.hfad.popularlibrariesrxjava2dagger2moxy.utils.schedulers.Schedulers
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface GithubModule {


    /**
     * Абстрактный вариант создания фабрики через @Binds а не через @Provides,
     * даёт больше гибкости для провайда наших зависимостей
     */

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindUsersFragment(): UsersListFragment

    @ContributesAndroidInjector
    fun bindUserFragment(): UserFragment

    @ContributesAndroidInjector
    fun bindRepoFragment(): RepoFragment


    @Binds
    fun bindGithubUsersRepo(
        repository: RepositoryImpl
    ): GithubUsersRepo

    @Binds
    fun bindCloudSource(
        cloud: RetrofitGithubUsersRepoImpl
    ): CloudSource

    @Binds
    fun bindDataSource(
        storage: RoomRepositoryImpl
    ): DataSource

    @Binds
    fun bindNetworkStatus(
        network: AndroidNetworkStatus
    ): NetworkStatus


    @Binds
    fun bindScheduler(
        schedulers: DefaultSchedulers
    ): Schedulers


}