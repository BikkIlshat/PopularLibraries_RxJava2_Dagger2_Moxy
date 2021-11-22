package com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.screens

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ScreenView : MvpView {
    fun showToast(message: String)
}