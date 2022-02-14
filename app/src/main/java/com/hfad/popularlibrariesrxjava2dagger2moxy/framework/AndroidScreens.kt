package com.hfad.popularlibrariesrxjava2dagger2moxy.framework

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hfad.popularlibrariesrxjava2dagger2moxy.framework.fragments.UserFragment
import com.hfad.popularlibrariesrxjava2dagger2moxy.framework.fragments.UsersFragment
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.data.user.GitHubUser
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.presenters.IScreens

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen {
        UsersFragment.newInstance()
    }

    override fun user(user: GitHubUser) = FragmentScreen {
        UserFragment.newInstance(user)
    }
}