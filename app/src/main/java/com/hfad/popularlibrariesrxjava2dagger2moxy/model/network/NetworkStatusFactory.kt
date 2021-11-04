package com.hfad.popularlibrariesrxjava2dagger2moxy.model.network

import android.content.Context

object NetworkStatusFactory {
    fun create(context: Context?) : NetworkStatus = AndroidNetworkStatus(context)
}