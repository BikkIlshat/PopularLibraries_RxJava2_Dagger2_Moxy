package com.hfad.popularlibrariesrxjava2dagger2moxy.presentation

import com.github.terrakok.cicerone.Router
import com.hfad.popularlibrariesrxjava2dagger2moxy.navigation.UsersScreen
import com.hfad.popularlibrariesrxjava2dagger2moxy.views.MainView
import moxy.MvpPresenter


class MainPresenter(
    private val router: Router
) : MvpPresenter<MainView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.newRootScreen(UsersScreen.create())
    }

}