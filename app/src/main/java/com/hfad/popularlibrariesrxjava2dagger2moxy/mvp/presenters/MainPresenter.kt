package com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.presenters

import com.github.terrakok.cicerone.Router
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.MainView
import moxy.MvpPresenter

class MainPresenter(
    private val router: Router,
    private val screens: IScreens
    ) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.users())
    }

    fun backClicked() {
        router.exit()
    }
}