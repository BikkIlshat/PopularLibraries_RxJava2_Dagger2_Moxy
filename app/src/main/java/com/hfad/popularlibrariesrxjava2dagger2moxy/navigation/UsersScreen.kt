package com.hfad.popularlibrariesrxjava2dagger2moxy.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hfad.popularlibrariesrxjava2dagger2moxy.ui.UsersListFragment

object UsersScreen {
    fun create() = FragmentScreen { UsersListFragment.newInstance() }
}