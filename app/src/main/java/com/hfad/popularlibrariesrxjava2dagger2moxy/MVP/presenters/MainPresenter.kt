package com.hfad.popularlibrariesrxjava2dagger2moxy.MVP.presenters

import com.hfad.popularlibrariesrxjava2dagger2moxy.MVP.models.CountersModel
import com.hfad.popularlibrariesrxjava2dagger2moxy.MVP.numbers.Numbers
import com.hfad.popularlibrariesrxjava2dagger2moxy.MVP.views.MainView

class MainPresenter(
    private val view: MainView,
    private val model: CountersModel = CountersModel()
) {


    //Архитектурная ошибка. В качестве практического задания -- исправить
    fun counterClick(BtnCounter: Numbers) {
        when (BtnCounter) {
            Numbers.ONE -> {
                view.setCounter1(model.next(0).toString())
            }
            Numbers.TWO -> {
                view.setCounter2(model.next(1).toString())
            }
            Numbers.THREE -> {
                view.setCounter3(model.next(2).toString())
            }
        }
    }
}