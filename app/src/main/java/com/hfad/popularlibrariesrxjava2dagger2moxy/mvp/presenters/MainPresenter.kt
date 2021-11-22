package com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.presenters

import com.github.terrakok.cicerone.Router
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.MainView
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.screens.UsersScreen
import moxy.MvpPresenter

class MainPresenter(
    private val router: Router,
) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.newRootScreen(UsersScreen.create())
    }

    fun backClicked() = router.exit()

}