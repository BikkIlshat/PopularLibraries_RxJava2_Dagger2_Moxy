package com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.presenters.user

import com.github.terrakok.cicerone.Router
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.data.user.GitHubUser
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.user.UserView
import moxy.MvpPresenter

class UserPresenter(
    private val router: Router,
    private val user: GitHubUser
) : MvpPresenter<UserView>() {


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setLogin(user.login)
    }


    fun backPressed(): Boolean {
        router.exit()
        return true
    }


}