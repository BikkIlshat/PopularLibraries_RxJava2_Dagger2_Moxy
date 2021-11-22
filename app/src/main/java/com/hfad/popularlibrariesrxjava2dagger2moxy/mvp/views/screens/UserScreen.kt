package com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hfad.popularlibrariesrxjava2dagger2moxy.framework.fragments.UserFragment

class UserScreen(private val login: String) {
    fun create() = FragmentScreen { UserFragment.newInstance(login) }
}