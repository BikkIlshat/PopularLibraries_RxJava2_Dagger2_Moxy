package com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.presenters.users

import com.github.terrakok.cicerone.Router
import com.hfad.popularlibrariesrxjava2dagger2moxy.data.user.GitHubUserRepository
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.GithubUserViewModel
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.screens.UserScreen
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.users.UsersView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UsersPresenter(
    private val usersRepo: GitHubUserRepository,
    private val router: Router,
) : MvpPresenter<UsersView>() {

    private val disposable: CompositeDisposable = CompositeDisposable()

    val usersListPresenter : UsersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = { itemView ->
            val login = usersListPresenter.users[itemView.pos].login
            router.navigateTo(UserScreen(login).create())
        }
    }

    private fun loadData() {
        disposable +=
            usersRepo.getUsers()
                .observeOn(Schedulers.computation())
                .map { users ->
                    val list = mutableListOf<GithubUserViewModel>()
                    for (i in users.indices) {
                        list.add(GithubUserViewModel.Mapper.map(users[i]))
                    }
                    list
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { users ->
                        usersListPresenter.users.addAll(users)
                        viewState.updateList()
                    },
                    { error ->
                        viewState.showToast(error.message ?: "Load users error")
                    }
                )

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