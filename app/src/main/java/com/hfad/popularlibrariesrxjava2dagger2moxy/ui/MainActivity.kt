package com.hfad.popularlibrariesrxjava2dagger2moxy.ui

import android.os.Bundle
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.hfad.popularlibrariesrxjava2dagger2moxy.R
import com.hfad.popularlibrariesrxjava2dagger2moxy.databinding.ActivityMainBinding
import com.hfad.popularlibrariesrxjava2dagger2moxy.presentation.MainPresenter
import com.hfad.popularlibrariesrxjava2dagger2moxy.ui.abs.AbsActivity
import com.hfad.popularlibrariesrxjava2dagger2moxy.views.MainView
import dagger.android.support.DaggerAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class MainActivity : AbsActivity(R.layout.activity_main), MainView{

    private val binding: ActivityMainBinding by viewBinding(CreateMethod.INFLATE)
    private val navigator = AppNavigator(this, R.id.container)

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: Router

    private val presenter by moxyPresenter { MainPresenter(router) }
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