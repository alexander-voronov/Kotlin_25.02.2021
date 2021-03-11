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
import ru.geekbrains.kotlin_25022021.ui.BackClickListener
import ru.geekbrains.kotlin_25022021.ui.adapter.UsersRVAdapter

class UsersFragment : MvpAppCompatFragment(), UsersView, BackClickListener {

    companion object {
        fun newInstance() = UsersFragment()
    }

    private val presenter by moxyPresenter {
        UsersPresenter(GithubUsersRepo(), App.instance.router)
    }

    private var vb: FragmentUsersBinding? = null
    private var adapter: UsersRVAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentUsersBinding.inflate(inflater, container, false).also {
        vb = it
    }.root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun init() {
        vb?.rvUsers?.layoutManager = LinearLayoutManager(requireContext())
        adapter = UsersRVAdapter(presenter.usersListPresenter)
        vb?.rvUsers?.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backClick()

}