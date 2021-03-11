package ru.geekbrains.kotlin_25022021.ui.activity

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.geekbrains.kotlin_25022021.R
import ru.geekbrains.kotlin_25022021.databinding.ActivityMainBinding
import ru.geekbrains.kotlin_25022021.mvp.presenter.MainPresenter
import ru.geekbrains.kotlin_25022021.mvp.view.MainView
import ru.geekbrains.kotlin_25022021.ui.App
import ru.geekbrains.kotlin_25022021.ui.BackClickListener
import ru.geekbrains.kotlin_25022021.ui.adapter.UsersRVAdapter
import ru.geekbrains.kotlin_25022021.ui.navigation.AndroidScreens


class MainActivity : MvpAppCompatActivity(), MainView {

    val navigator = AppNavigator(this, R.id.container)

    private var vb: ActivityMainBinding? = null
    private val presenter by moxyPresenter {
        MainPresenter(App.instance.router, AndroidScreens())
    }

    private var adapter: UsersRVAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if(it is BackClickListener && it.backPressed()){
                return
            }
        }
        presenter.backClicked()
    }

}