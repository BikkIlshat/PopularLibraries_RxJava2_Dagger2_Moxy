package com.hfad.popularlibrariesrxjava2dagger2moxy

import android.os.Bundle
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.hfad.popularlibrariesrxjava2dagger2moxy.App.Navigation.navigatorHolder
import com.hfad.popularlibrariesrxjava2dagger2moxy.App.Navigation.router
import com.hfad.popularlibrariesrxjava2dagger2moxy.databinding.ActivityMainBinding
import com.hfad.popularlibrariesrxjava2dagger2moxy.presentation.MainPresenter
import com.hfad.popularlibrariesrxjava2dagger2moxy.views.MainView
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {
    private val binding : ActivityMainBinding by viewBinding(CreateMethod.INFLATE)
    private val navigator = AppNavigator(this, R.id.container)
    private val mainPresenter by moxyPresenter { MainPresenter(router) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }



}