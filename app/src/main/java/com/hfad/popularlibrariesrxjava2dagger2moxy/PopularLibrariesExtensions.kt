package com.hfad.popularlibrariesrxjava2dagger2moxy

import android.view.View

fun View.click(click: () -> Unit) = setOnClickListener { click() }