package ru.geekbrains.kotlin_25022021.mvp.model.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class GithubUser(
    val login: String
) : Parcelable
