package com.hfad.popularlibrariesrxjava2dagger2moxy.views

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UsersView : MvpView {
    fun init()
    fun updateUsersList()
    fun showError(e: Throwable)
}