package com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.presenters.users

import com.github.terrakok.cicerone.Router
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.data.user.GitHubUserRepositoryImpl
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.data.user.GitHubUser
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.presenters.IScreens
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.presenters.IUserListPresenter
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.UserItemView
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.users.UsersView
import moxy.MvpPresenter

class UsersPresenter(
    private val usersRepo: GitHubUserRepositoryImpl,
    private val router: Router,
    private val screens: IScreens
) : MvpPresenter<UsersView>() {

    class UsersListPresenter : IUserListPresenter {

        val users = mutableListOf<GitHubUser>()

        override var itemClickListener: ((UserItemView) -> Unit)? = null

        override fun getCount() = users.size

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }

     val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = { itemView ->
            val user = usersListPresenter.users[itemView.pos]
            router.navigateTo(screens.user(user))
        }
    }

    private fun loadData() {
        val users = usersRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }

    fun backPressed() : Boolean {
        router.exit()
        return true
    }
}