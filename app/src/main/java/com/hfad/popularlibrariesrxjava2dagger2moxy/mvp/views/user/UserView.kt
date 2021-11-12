package com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.user

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserView : MvpView {
    fun setLogin(text: String)
}