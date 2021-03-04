package ru.geekbrains.kotlin_25022021.mvp.presenter

import ru.geekbrains.kotlin_25022021.R
import ru.geekbrains.kotlin_25022021.mvp.model.CountersModel
import ru.geekbrains.kotlin_25022021.mvp.view.MainView


class MainPresenter(val mainView: MainView) {
    val model = CountersModel()

    fun counterClick(id: Int) {
        when (id) {
            R.id.btn_counter1 -> {
                val nextValue = model.next(0)
                mainView.setButtonText(0, nextValue.toString())
            }
            R.id.btn_counter2 -> {
                val nextValue = model.next(1)
                mainView.setButtonText(1, nextValue.toString())
            }
            R.id.btn_counter3 -> {
                val nextValue = model.next(2)
                mainView.setButtonText(2, nextValue.toString())
            }
        }
    }
}