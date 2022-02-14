package com.hfad.popularlibrariesrxjava2dagger2moxy.ui.abs

import android.content.Context
import androidx.annotation.LayoutRes
import com.github.terrakok.cicerone.Router
import com.hfad.popularlibrariesrxjava2dagger2moxy.utils.ImageLoader
import com.hfad.popularlibrariesrxjava2dagger2moxy.utils.schedulers.Schedulers
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import moxy.MvpAppCompatFragment
import javax.inject.Inject

abstract class AbsFragment(@LayoutRes contentLayoutId: Int = 0) :
    MvpAppCompatFragment(contentLayoutId),
    HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    @Inject
    lateinit var imageLoader: ImageLoader

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var schedulers: Schedulers

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }
}