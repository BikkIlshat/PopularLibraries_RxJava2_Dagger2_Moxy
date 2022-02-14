package com.hfad.popularlibrariesrxjava2dagger2moxy.views

import com.hfad.popularlibrariesrxjava2dagger2moxy.model.GithubUser
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserView : MvpView {
    fun showUser(githubUser: GithubUser)
    fun showAvatar(githubUser: GithubUser)
    fun showError(error: Throwable)
    fun updateRepose()
    fun init()
}