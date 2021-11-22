package com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views

import com.hfad.popularlibrariesrxjava2dagger2moxy.data.user.GitHubUser

data class GithubUserViewModel(
    val login: String,
    val avatar_url: String,
    val repos_url: String,
) {
    object Mapper {
        fun map(user: GitHubUser) =
            GithubUserViewModel(
                user.login.uppercase(),
                user.avatar,
                user.repos_url
            )
    }
}