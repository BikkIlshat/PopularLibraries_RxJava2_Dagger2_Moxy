package com.hfad.popularlibrariesrxjava2dagger2moxy.model

import com.hfad.popularlibrariesrxjava2dagger2moxy.model.network.NetworkStatus
import com.hfad.popularlibrariesrxjava2dagger2moxy.model.retrofit.CloudFactory
import com.hfad.popularlibrariesrxjava2dagger2moxy.model.storage.StorageFactory
import com.hfad.popularlibrariesrxjava2dagger2moxy.utils.schedulers.SchedulersFactory


object RepositoryFactory {
    fun create(networkStatus: NetworkStatus): GithubUsersRepo =
        RepositoryImpl(
            CloudFactory.create(),
            StorageFactory.create(),
            networkStatus,
            SchedulersFactory.create()
        )
}