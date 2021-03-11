package ru.geekbrains.kotlin_25022021.ui.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.geekbrains.kotlin_25022021.mvp.navigation.IScreens
import ru.geekbrains.kotlin_25022021.ui.fragment.UsersFragment

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
}