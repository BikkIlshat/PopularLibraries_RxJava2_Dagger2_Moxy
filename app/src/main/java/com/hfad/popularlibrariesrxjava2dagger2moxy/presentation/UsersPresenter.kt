package com.hfad.popularlibrariesrxjava2dagger2moxy.presentation

import com.github.terrakok.cicerone.Router
import com.hfad.popularlibrariesrxjava2dagger2moxy.model.retrofit.GithubUser
import com.hfad.popularlibrariesrxjava2dagger2moxy.model.GithubUsersRepo
import com.hfad.popularlibrariesrxjava2dagger2moxy.navigation.UserScreen
import com.hfad.popularlibrariesrxjava2dagger2moxy.utils.schedulers.Schedulers
import com.hfad.popularlibrariesrxjava2dagger2moxy.views.UserItemView
import com.hfad.popularlibrariesrxjava2dagger2moxy.views.UsersView
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import moxy.MvpPresenter

class UsersPresenter(
    private val repo: GithubUsersRepo,
    private val router: Router,
    private val schedulers: Schedulers
) :
    MvpPresenter<UsersView>() {
    private var users = mutableListOf<GithubUser>()
    private var disposable = CompositeDisposable()

    /** создаем презентера для adapter's **/
    class UserListPresenter(private val router: Router) : UserItemListPresenter {
        val user = mutableListOf<GithubUser>()
        override var itemClickedListener: ((UserItemView) -> Unit)? = null

        override fun bindView(view: UserItemView) {
            val user = user[view.pos]
            user.login?.let { view.setLogin(it) }
            user.avatarUrl?.let { view.setAvatar(it) }

        }

        override fun getCount(): Int = user.size
    }

    val userListPresenter = UserListPresenter(router)
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
    }

    private fun loadData() {
        disposable += repo
            .getUsers().observeOn(schedulers.main())
            .subscribe(
                {
                    users.addAll(it)
                    userListPresenter.user.addAll(users)
                    viewState.updateUsersList()
                },
                viewState::showError
            )
        userListPresenter.itemClickedListener = { userItemView ->
            router.navigateTo(UserScreen(users[userItemView.pos]).create())
        }
    }



    override fun onDestroy() {
        disposable.clear()
    }

}