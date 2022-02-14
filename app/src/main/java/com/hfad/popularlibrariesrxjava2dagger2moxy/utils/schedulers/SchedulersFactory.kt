package com.hfad.popularlibrariesrxjava2dagger2moxy.utils.schedulers

object SchedulersFactory {
    fun create(): Schedulers = DefaultSchedulers()
}