package com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.presenters

import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.models.CountersModel
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.MainView
import moxy.MvpPresenter

class MainPresenter(
    private val model: CountersModel = CountersModel()
) : MvpPresenter<MainView>() {

 fun counterOneClick() {
     val nextValue = model.next(0)
     viewState.setButtonOneText(nextValue.toString())
 }

    fun counterTwoClick() {
        val nextValue = model.next(1)
        viewState.setButtonTwoText(nextValue.toString())
    }

    fun counterThreeClick() {
        val nextValue = model.next(2)
        viewState.setButtonThreeText(nextValue.toString())
    }

}