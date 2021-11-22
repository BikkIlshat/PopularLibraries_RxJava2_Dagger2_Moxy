package com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.presenters.user

import com.hfad.popularlibrariesrxjava2dagger2moxy.data.user.GitHubUserUserRepositories
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.user.UserRepoItemView

class UserReposListPresenter : IUserReposListPresenter {

    val repos = mutableListOf<GitHubUserUserRepositories>()

    override var itemClickListener: ((UserRepoItemView) -> Unit)? = null

    override fun bindView(view: UserRepoItemView) =
        view.setRepoName(repos[view.pos].name)

    override fun getCount() = repos.size
}
