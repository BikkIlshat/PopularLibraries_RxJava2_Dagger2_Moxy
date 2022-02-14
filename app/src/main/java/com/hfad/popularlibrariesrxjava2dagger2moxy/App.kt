package com.hfad.popularlibrariesrxjava2dagger2moxy

import com.github.terrakok.cicerone.Cicerone
import com.hfad.popularlibrariesrxjava2dagger2moxy.utils.ImageLoader
import com.hfad.popularlibrariesrxjava2dagger2moxy.di.DaggerApplicationComponent
import com.hfad.popularlibrariesrxjava2dagger2moxy.utils.schedulers.SchedulersFactory
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<App> =
        DaggerApplicationComponent
            .builder()
            .withContext(applicationContext)
            .withImageLoader(ImageLoader)
            .apply {
                val cicerone = Cicerone.create()
                withRouter(cicerone.router)
                withNavigationHolder(cicerone.getNavigatorHolder())
            }
            .build()
}