package ru.geekbrains.kotlin_25022021.ui.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.geekbrains.kotlin_25022021.mvp.model.entity.GithubUser
import ru.geekbrains.kotlin_25022021.mvp.navigation.IScreens
import ru.geekbrains.kotlin_25022021.ui.fragment.UserFragment
import ru.geekbrains.kotlin_25022021.ui.fragment.UsersFragment

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
    override fun user(githubUser: GithubUser) =
        FragmentScreen { UserFragment.newInstance(githubUser) }
}