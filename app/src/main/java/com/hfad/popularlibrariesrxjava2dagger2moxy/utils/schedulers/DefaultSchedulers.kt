package com.hfad.popularlibrariesrxjava2dagger2moxy.utils.schedulers

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler

class DefaultSchedulers : Schedulers {
    override fun main(): Scheduler = AndroidSchedulers.mainThread()

    override fun background(): Scheduler = io.reactivex.rxjava3.schedulers.Schedulers.io()
}