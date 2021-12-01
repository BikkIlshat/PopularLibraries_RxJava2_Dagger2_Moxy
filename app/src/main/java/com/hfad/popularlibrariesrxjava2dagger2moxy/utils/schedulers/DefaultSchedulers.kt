package com.hfad.popularlibrariesrxjava2dagger2moxy.utils.schedulers

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import javax.inject.Inject

class DefaultSchedulers @Inject constructor() : Schedulers {

    override fun main(): Scheduler = AndroidSchedulers.mainThread()
    override fun background(): Scheduler = io.reactivex.rxjava3.schedulers.Schedulers.io()
}