package ru.geekbrains.kotlin_25022021.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.geekbrains.kotlin_25022021.databinding.ActivityMainBinding
import ru.geekbrains.kotlin_25022021.mvp.presenter.MainPresenter
import ru.geekbrains.kotlin_25022021.mvp.view.MainView


class MainActivity : AppCompatActivity(), MainView {

    private var vb: ActivityMainBinding? = null
    val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)

        vb?.btnCounter1?.setOnClickListener (presenter.counterOneClick())
        vb?.btnCounter2?.setOnClickListener(presenter.counterTwoClick())
        vb?.btnCounter3?.setOnClickListener(presenter.counterThreeClick())
    }

    override fun setButtonOneText(text: String) {
        vb?.btnCounter1?.text = text
    }

    override fun setButtonTwoText(text: String) {
        vb?.btnCounter2?.text = text
    }

    override fun setButtonThreeText(text: String) {
        vb?.btnCounter3?.text = text
    }
}