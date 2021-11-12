package com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.users

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UsersView  : MvpView {
    fun init()
    fun updateList()
}
