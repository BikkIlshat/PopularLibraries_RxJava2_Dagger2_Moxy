package com.hfad.popularlibrariesrxjava2dagger2moxy.model

import com.hfad.popularlibrariesrxjava2dagger2moxy.model.retrofit.GithubUser

object Mapper {
    fun filter(users: List<GithubUser>, login: String) = users.find { user -> user.login == login }
}