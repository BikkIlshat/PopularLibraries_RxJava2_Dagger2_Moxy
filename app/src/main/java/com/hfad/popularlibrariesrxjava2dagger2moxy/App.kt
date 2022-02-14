package com.hfad.popularlibrariesrxjava2dagger2moxy

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.hfad.popularlibrariesrxjava2dagger2moxy.model.storage.RoomDB

class App : Application() {
    companion object Navigation {

        private val cicerone : Cicerone<Router> by lazy {
            Cicerone.create()
        }
        val navigatorHolder = cicerone.getNavigatorHolder()
        val router = cicerone.router
    }

    override fun onCreate() {
        super.onCreate()
        RoomDB.create(this)
    }
}