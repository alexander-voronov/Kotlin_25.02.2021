package ru.geekbrains.kotlin_25022021.mvp.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.geekbrains.kotlin_25022021.mvp.model.entity.GithubUser
import ru.geekbrains.kotlin_25022021.mvp.view.UserView

class UserPresenter(val router: Router, val user: GithubUser) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setLogin(user.login)
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}