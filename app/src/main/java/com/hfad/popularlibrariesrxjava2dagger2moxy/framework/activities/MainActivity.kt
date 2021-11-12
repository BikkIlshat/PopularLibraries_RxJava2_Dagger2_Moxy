package com.hfad.popularlibrariesrxjava2dagger2moxy.framework.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hfad.popularlibrariesrxjava2dagger2moxy.MVP.numbers.Numbers
import com.hfad.popularlibrariesrxjava2dagger2moxy.MVP.presenters.MainPresenter
import com.hfad.popularlibrariesrxjava2dagger2moxy.MVP.views.MainView
import com.hfad.popularlibrariesrxjava2dagger2moxy.R
import com.hfad.popularlibrariesrxjava2dagger2moxy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main), MainView {

    private val binding by viewBinding(ActivityMainBinding::bind)

    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setButtonOnClickListener()
    }


    private fun setButtonOnClickListener() = with(binding) {
        btnCounter1.setOnClickListener {
            presenter.counterClick(Numbers.ONE)
        }
        btnCounter2.setOnClickListener {
            presenter.counterClick(Numbers.TWO)
        }
        btnCounter3.setOnClickListener {
            presenter.counterClick(Numbers.THREE)
        }
    }


    //Подсказка к ПЗ: поделить на 3 отдельные функции и избавиться от index
    override fun setCounter1(text: String) = with(binding) { btnCounter1.text = text }

    override fun setCounter2(text: String) = with(binding) { btnCounter2.text = text }

    override fun setCounter3(text: String) = with(binding) { btnCounter3.text = text }

}