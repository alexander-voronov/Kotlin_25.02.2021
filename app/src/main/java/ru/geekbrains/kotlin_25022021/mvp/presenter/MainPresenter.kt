package ru.geekbrains.kotlin_25022021.mvp.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.geekbrains.kotlin_25022021.mvp.navigation.IScreens
import ru.geekbrains.kotlin_25022021.mvp.view.MainView


class MainPresenter(val router: Router, val screens: IScreens) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.users())
    }

    fun backClicked() {
        router.exit()
    }

}