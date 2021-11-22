package com.hfad.popularlibrariesrxjava2dagger2moxy.data.user

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GitHubUserUserRepositories(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("forks")
    val forkCount: Int,
) : Parcelable