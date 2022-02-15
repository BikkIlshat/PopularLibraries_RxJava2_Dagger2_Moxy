package com.hfad.popularlibrariesrxjava2dagger2moxy.di

import android.content.Context
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.hfad.popularlibrariesrxjava2dagger2moxy.App
import com.hfad.popularlibrariesrxjava2dagger2moxy.di.modules.GithubApiModule
import com.hfad.popularlibrariesrxjava2dagger2moxy.di.modules.GithubModule
import com.hfad.popularlibrariesrxjava2dagger2moxy.di.modules.StorageModule
import com.hfad.popularlibrariesrxjava2dagger2moxy.utils.ImageLoader
import com.hfad.popularlibrariesrxjava2dagger2moxy.utils.schedulers.Schedulers
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class, GithubApiModule::class, GithubModule::class,
        StorageModule::class]
)

interface ApplicationComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withRouter(router: Router): Builder

        @BindsInstance
        fun withNavigationHolder(navigatorHolder: NavigatorHolder): Builder

        @BindsInstance
        fun withImageLoader(imageLoader: ImageLoader): Builder
        fun build(): ApplicationComponent
    }


}