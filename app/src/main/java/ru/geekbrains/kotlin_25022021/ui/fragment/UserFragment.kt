package ru.geekbrains.kotlin_25022021.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.kotlin_25022021.databinding.FragmentUserBinding
import ru.geekbrains.kotlin_25022021.mvp.model.entity.GithubUser
import ru.geekbrains.kotlin_25022021.mvp.presenter.UserPresenter
import ru.geekbrains.kotlin_25022021.mvp.view.UserView
import ru.geekbrains.kotlin_25022021.ui.App
import ru.geekbrains.kotlin_25022021.ui.BackButtonListener


class UserFragment : MvpAppCompatFragment(), UserView, BackButtonListener {

    companion object {
        private const val USER_ARG = "user"

        fun newInstance(user: GithubUser) = UserFragment().apply {
            arguments = Bundle().apply {
                putParcelable(USER_ARG, user)
            }
        }
    }

    val presenter: UserPresenter by moxyPresenter {
        val user =
            arguments?.getParcelable<GithubUser>(USER_ARG) as GithubUser //При отсутствии аргумента приложение упадет. Так задумано.
        UserPresenter(App.instance.router, user)
    }

    private var vb: FragmentUserBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentUserBinding.inflate(inflater, container, false).also {
            vb = it
        }.root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun setLogin(text: String) {
        vb?.tvLogin?.text = text
    }

    override fun backPressed() = presenter.backPressed()

}