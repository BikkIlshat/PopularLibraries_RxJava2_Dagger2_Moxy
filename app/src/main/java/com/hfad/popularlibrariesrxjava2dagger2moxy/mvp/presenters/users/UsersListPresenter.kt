package com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.presenters.users

import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.GithubUserViewModel
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.user.UserItemView

class UsersListPresenter : IUserListPresenter {

    val users = mutableListOf<GithubUserViewModel>()

    override var itemClickListener: ((UserItemView) -> Unit)? = null

    override fun getCount() = users.size

    override fun bindView(view: UserItemView) {
        val user = users[view.pos]
        view.setLogin(user.login, user.avatar_url)
    }
}
