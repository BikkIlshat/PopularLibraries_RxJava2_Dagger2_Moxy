package com.hfad.popularlibrariesrxjava2dagger2moxy.presentation

import com.hfad.popularlibrariesrxjava2dagger2moxy.model.GithubUsersRepo
import com.hfad.popularlibrariesrxjava2dagger2moxy.utils.schedulers.Schedulers
import com.hfad.popularlibrariesrxjava2dagger2moxy.views.RepoView
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import moxy.MvpPresenter
import javax.inject.Inject

class RepoPresenter
@Inject constructor(
    private val gitHubRepo: GithubUsersRepo,
    private val repoUrl: String?,
    private val schedulers: Schedulers
) : MvpPresenter<RepoView>() {
    private val disposable = CompositeDisposable()
    override fun onFirstViewAttach() {
        disposable += gitHubRepo
            .getRepo(repoUrl)
            .observeOn(schedulers.main())
            .subscribe(
                {
                    viewState.showRepoName(it)
                    viewState.showRepoForks(it)
                    viewState.showRepoDate(it)
                },
                viewState::showError
            )
    }

    override fun onDestroy() {
        disposable.clear()
    }
}