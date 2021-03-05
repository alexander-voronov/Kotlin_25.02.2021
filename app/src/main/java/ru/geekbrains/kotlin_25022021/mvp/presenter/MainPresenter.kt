package ru.geekbrains.kotlin_25022021.mvp.presenter

import ru.geekbrains.kotlin_25022021.mvp.model.CountersModel
import ru.geekbrains.kotlin_25022021.mvp.view.MainView


class MainPresenter(val view: MainView) {
    val model = CountersModel()

    fun counterOneClick() {
        val nextValue = model.next(0)
        view.setButtonOneText(nextValue.toString())
    }

    fun counterTwoClick() {
        val nextValue = model.next(1)
        view.setButtonOneText(nextValue.toString())
    }

    fun counterThreeClick() {
        val nextValue = model.next(2)
        view.setButtonOneText(nextValue.toString())
    }

}