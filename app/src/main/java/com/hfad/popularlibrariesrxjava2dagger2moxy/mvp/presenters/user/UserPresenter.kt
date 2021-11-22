package com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.presenters.user

import com.hfad.popularlibrariesrxjava2dagger2moxy.data.user.GitHubUserRepository
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.GithubUserViewModel
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.user.UserView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UserPresenter(
    private val userLogin: String,
    private val userRepository: GitHubUserRepository
) : MvpPresenter<UserView>() {

    private val disposables = CompositeDisposable()
    val reposPresenter: UserReposListPresenter = UserReposListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        disposables +=
            userRepository.getUserByLogin(userLogin)
                .observeOn(Schedulers.computation())
                .map { GithubUserViewModel.Mapper.map(it) }
                .defaultIfEmpty(GithubUserViewModel("Unknown", "http://unknown", "http://unknown"))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { user ->
                        viewState.showUser(user)
                        getUserRepos(user.repos_url)
                        setRepoItemClickListener()
                    },
                    { error -> viewState.showToast(error.message ?: "get user error") }
                )

    }

    private fun getUserRepos(url: String) {
        disposables +=
            userRepository.getUserRepositories(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { repos ->
                        reposPresenter.repos.apply {
                            clear()
                            addAll(repos)
                        }
                        viewState.updateRepos()
                    }, { error ->
                        viewState.showToast(error.message ?: "error get user repositories")
                    }
                )
    }

    private fun setRepoItemClickListener() {
        reposPresenter.itemClickListener = { itemView ->
            viewState.showRepo(reposPresenter.repos[itemView.pos])
        }
    }

    override fun onDestroy() {
        disposables.clear()
        super.onDestroy()
    }

}