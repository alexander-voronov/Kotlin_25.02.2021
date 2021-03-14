package ru.geekbrains.kotlin_25022021.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.kotlin_25022021.databinding.FragmentUsersBinding
import ru.geekbrains.kotlin_25022021.mvp.model.GithubUsersRepo
import ru.geekbrains.kotlin_25022021.mvp.presenter.UsersPresenter
import ru.geekbrains.kotlin_25022021.mvp.view.UsersView
import ru.geekbrains.kotlin_25022021.ui.App
import ru.geekbrains.kotlin_25022021.ui.BackButtonListener
import ru.geekbrains.kotlin_25022021.ui.adapter.UsersRVAdapter
import ru.geekbrains.kotlin_25022021.ui.navigation.AndroidScreens

class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {
    companion object {
        fun newInstance() = UsersFragment()
    }

    val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            GithubUsersRepo(),
            App.instance.router,
            AndroidScreens()
        )
    }
    var adapter: UsersRVAdapter? = null

    private var vb: FragmentUsersBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentUsersBinding.inflate(inflater, container, false).also {
            vb = it
        }.root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun init() {
        vb?.rvUsers?.layoutManager = LinearLayoutManager(context)
        adapter = UsersRVAdapter(presenter.usersListPresenter)
        vb?.rvUsers?.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()
}