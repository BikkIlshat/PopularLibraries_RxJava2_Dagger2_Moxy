package com.hfad.popularlibrariesrxjava2dagger2moxy.navigation

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hfad.popularlibrariesrxjava2dagger2moxy.model.GithubRepos
import com.hfad.popularlibrariesrxjava2dagger2moxy.ui.RepoFragment

class RepoScreen(private val repo: GithubRepos) {
    fun create() : Screen = FragmentScreen{ RepoFragment.newInstance(repo.url)}
}