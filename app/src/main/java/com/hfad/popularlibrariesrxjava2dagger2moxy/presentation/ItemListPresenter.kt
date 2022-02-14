package com.hfad.popularlibrariesrxjava2dagger2moxy.presentation

import com.hfad.popularlibrariesrxjava2dagger2moxy.views.ItemView
import com.hfad.popularlibrariesrxjava2dagger2moxy.views.UserItemView

interface ItemListPresenter<View : ItemView> {
    var itemClickedListener: ((View) -> Unit)?
    fun bindView(view: View)
    fun getCount(): Int
}

interface UserItemListPresenter : ItemListPresenter<UserItemView>

