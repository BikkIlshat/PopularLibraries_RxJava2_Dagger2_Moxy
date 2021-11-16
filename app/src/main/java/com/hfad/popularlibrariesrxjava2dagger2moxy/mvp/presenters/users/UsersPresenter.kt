package com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.presenters.users

import com.github.terrakok.cicerone.Router
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.data.user.GitHubUserRepositoryImpl
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.presenters.IScreens
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.users.UsersView
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class UsersPresenter(
    private val usersRepo: GitHubUserRepositoryImpl,
    private val router: Router,
    private val screens: IScreens,
    val usersListPresenter: UsersListPresenter = UsersListPresenter()
) : MvpPresenter<UsersView>() {

    private val disposable = CompositeDisposable()

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
        disposable.add(
            usersRepo
                .getUsers()
                .subscribe { users ->
                    usersListPresenter.users.addAll(users)
                }
        )
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
    }
}