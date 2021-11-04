package com.hfad.popularlibrariesrxjava2dagger2moxy.framework.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hfad.popularlibrariesrxjava2dagger2moxy.MVP.presenters.MainPresenter
import com.hfad.popularlibrariesrxjava2dagger2moxy.MVP.views.MainView
import com.hfad.popularlibrariesrxjava2dagger2moxy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    private var vb: ActivityMainBinding? = null
    val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)

        val listener = View.OnClickListener {
            presenter.counterClick(it.id)
        }

        vb?.btnCounter1?.setOnClickListener(listener)
        vb?.btnCounter2?.setOnClickListener(listener)
        vb?.btnCounter3?.setOnClickListener(listener)
    }

    //Подсказка к ПЗ: поделить на 3 отдельные функции и избавиться от index
    override fun setButtonText(index: Int, text: String) {
        when(index){
            0 -> vb?.btnCounter1?.text = text
            1 -> vb?.btnCounter2?.text = text
            2 -> vb?.btnCounter3?.text = text
        }
    }
}