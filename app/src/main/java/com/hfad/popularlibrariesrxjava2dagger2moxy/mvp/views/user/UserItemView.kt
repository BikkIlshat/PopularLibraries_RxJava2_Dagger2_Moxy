package com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.user

import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.IItemView


interface UserItemView : IItemView {
    fun setLogin(login: String, avatar_url: String)
}