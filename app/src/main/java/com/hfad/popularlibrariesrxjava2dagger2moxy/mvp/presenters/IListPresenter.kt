package com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.presenters

import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.IItemView


interface IListPresenter<V : IItemView> {

    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}
