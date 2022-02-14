package com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.user

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

@SingleState
interface UserView : MvpView {
    fun setLogin(text: String)
}