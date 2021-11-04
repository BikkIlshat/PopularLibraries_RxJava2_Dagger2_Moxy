package com.hfad.popularlibrariesrxjava2dagger2moxy.model.storage

import com.hfad.popularlibrariesrxjava2dagger2moxy.utils.schedulers.SchedulersFactory


object StorageFactory {
    fun create(): Storage =
        RoomRepositoryImpl(RoomDB.getInstance() as RoomDB, SchedulersFactory.create())
}