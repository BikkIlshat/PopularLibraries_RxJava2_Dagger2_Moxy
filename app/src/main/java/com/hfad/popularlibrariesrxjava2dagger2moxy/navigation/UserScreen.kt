package com.hfad.popularlibrariesrxjava2dagger2moxy.navigation

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hfad.popularlibrariesrxjava2dagger2moxy.model.retrofit.GithubUser
import com.hfad.popularlibrariesrxjava2dagger2moxy.ui.UserFragment

class UserScreen(private val githubUser: GithubUser) {
    fun create(): Screen = FragmentScreen { UserFragment.newInstance(githubUser.login) }
}