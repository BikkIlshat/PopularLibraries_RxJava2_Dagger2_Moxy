package com.hfad.popularlibrariesrxjava2dagger2moxy.views

interface RepoItemView : ItemView {
    fun setRepoName(name: String?)
    fun setLanguage(language: String?)
    fun setDate(date: String?)
}