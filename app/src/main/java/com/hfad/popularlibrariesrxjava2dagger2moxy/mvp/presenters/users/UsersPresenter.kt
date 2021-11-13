package com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.presenters.users

import com.github.terrakok.cicerone.Router
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.data.user.GitHubUserRepositoryImpl
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.presenters.IScreens
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.users.UsersView
import moxy.MvpPresenter

class UsersPresenter(
    private val usersRepo: GitHubUserRepositoryImpl,
    private val router: Router,
    private val screens: IScreens
    val usersListPresenter = UsersListPresenter()
) : MvpPresenter<UsersView>() {

     

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

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}
