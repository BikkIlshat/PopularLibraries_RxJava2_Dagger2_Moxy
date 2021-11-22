package com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hfad.popularlibrariesrxjava2dagger2moxy.framework.fragments.UsersFragment

object UsersScreen {
    fun create() = FragmentScreen { UsersFragment.newInstance() }
}