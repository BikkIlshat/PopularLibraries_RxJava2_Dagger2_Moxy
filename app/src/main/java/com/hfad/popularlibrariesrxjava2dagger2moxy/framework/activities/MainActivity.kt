package com.hfad.popularlibrariesrxjava2dagger2moxy.framework.activities

import com.github.terrakok.cicerone.androidx.AppNavigator
import com.hfad.popularlibrariesrxjava2dagger2moxy.R
import com.hfad.popularlibrariesrxjava2dagger2moxy.framework.AndroidScreens
import com.hfad.popularlibrariesrxjava2dagger2moxy.framework.App
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.presenters.BackButtonListener
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.presenters.MainPresenter
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.MainView
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(R.layout.activity_main), MainView {

    
    private val navigator = AppNavigator(this, R.id.container)

    private val presenter by moxyPresenter {
        MainPresenter(App.instance.router, AndroidScreens())
    }


    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()) {
                return
            }
        }
        presenter.backClicked()
    }
}