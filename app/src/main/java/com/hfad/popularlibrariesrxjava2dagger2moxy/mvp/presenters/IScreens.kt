package com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.presenters

import com.github.terrakok.cicerone.Screen
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.data.user.GitHubUser

interface IScreens {
    fun users(): Screen
    fun user(user: GitHubUser): Screen
}