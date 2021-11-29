package com.hfad.popularlibrariesrxjava2dagger2moxy.model

object Mapper {
    fun filter(users: List<GithubUser>, login: String) = users.find { user -> user.login == login }
}