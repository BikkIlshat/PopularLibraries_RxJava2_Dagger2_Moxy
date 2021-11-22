package com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.users

import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.screens.ScreenView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UsersView : ScreenView {
    fun init()
    fun updateList()
}
