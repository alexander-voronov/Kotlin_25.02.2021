package ru.geekbrains.kotlin_25022021.mvp.navigation

import com.github.terrakok.cicerone.Screen
import ru.geekbrains.kotlin_25022021.mvp.model.entity.GithubUser

interface IScreens {
    fun users(): Screen
    fun user(githubUser: GithubUser): Screen
}