package com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.user

import com.hfad.popularlibrariesrxjava2dagger2moxy.data.user.GitHubUserUserRepositories
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.GithubUserViewModel
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.screens.ScreenView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserView : ScreenView {
    fun showUser(user: GithubUserViewModel)
    fun updateRepos()
    fun init()
    fun showRepo(repo: GitHubUserUserRepositories)
}