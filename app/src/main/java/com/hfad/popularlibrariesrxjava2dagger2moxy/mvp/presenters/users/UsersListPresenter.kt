package com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.presenters.users

import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.data.user.GitHubUser
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.presenters.IUserListPresenter
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.UserItemView

class UsersListPresenter : IUserListPresenter {

    val users = mutableListOf<GitHubUser>()

    override var itemClickListener: ((UserItemView) -> Unit)? = null

    override fun getCount() = users.size

    override fun bindView(view: UserItemView) {
        val user = users[view.pos]
        view.setLogin(user.login)
    }
}
