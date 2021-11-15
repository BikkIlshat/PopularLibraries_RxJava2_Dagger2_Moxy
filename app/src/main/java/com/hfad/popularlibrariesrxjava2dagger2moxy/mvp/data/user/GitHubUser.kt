package com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.data.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Модель, представляющая пользователя:
 */
@Parcelize
data class GitHubUser (val login: String) : Parcelable
