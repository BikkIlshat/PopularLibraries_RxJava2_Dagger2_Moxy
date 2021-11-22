package com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.user

import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.IItemView

interface UserRepoItemView : IItemView {
    fun setRepoName(repoName: String)
}