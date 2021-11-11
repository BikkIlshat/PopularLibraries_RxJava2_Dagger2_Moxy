package com.hfad.popularlibrariesrxjava2dagger2moxy.framework.activities

import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.models.CountersModel
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.presenters.MainPresenter
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.MainView
import com.hfad.popularlibrariesrxjava2dagger2moxy.R
import com.hfad.popularlibrariesrxjava2dagger2moxy.databinding.ActivityMainBinding
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(R.layout.activity_main), MainView {

    private val binding by viewBinding(ActivityMainBinding::bind)

    private val presenter by moxyPresenter { MainPresenter(CountersModel()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setButtonOnClickListener()
    }


    private fun setButtonOnClickListener() = with(binding) {
        btnCounter1.setOnClickListener {
            presenter.counterOneClick()
        }
        btnCounter2.setOnClickListener {
            presenter.counterTwoClick()
        }
        btnCounter3.setOnClickListener {
            presenter.counterThreeClick()
        }
    }



    override fun setButtonOneText(text: String) = with(binding) { btnCounter1.text = text }

    override fun setButtonTwoText(text: String) = with(binding) { btnCounter2.text = text }

    override fun setButtonThreeText(text: String) = with(binding) { btnCounter3.text = text }

}