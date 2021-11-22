package com.hfad.popularlibrariesrxjava2dagger2moxy.data.user

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Модель, представляющая пользователя:
 */
@Parcelize
data class GitHubUser(
    @SerializedName("id")
    val id: String,
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatar: String,
    @SerializedName("repos_url")
    val repos_url: String
) : Parcelable
