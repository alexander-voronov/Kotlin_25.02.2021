package ru.geekbrains.kotlin_25022021.mvp.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.geekbrains.kotlin_25022021.mvp.model.GithubUsersRepo
import ru.geekbrains.kotlin_25022021.mvp.model.entity.GithubUser
import ru.geekbrains.kotlin_25022021.mvp.navigation.IScreens
import ru.geekbrains.kotlin_25022021.mvp.presenter.list.IUserListPresenter
import ru.geekbrains.kotlin_25022021.mvp.view.UsersView
import ru.geekbrains.kotlin_25022021.mvp.view.list.UserItemView


class UsersPresenter(val usersRepo: GithubUsersRepo, val router: Router, val screens: IScreens) :
    MvpPresenter<UsersView>() {
    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GithubUser>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null

        override fun getCount() = users.size

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = { itemView ->
            val user = usersListPresenter.users[itemView.pos]
            router.navigateTo(screens.user(user))
        }
    }

    fun loadData() {
        val users = usersRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}