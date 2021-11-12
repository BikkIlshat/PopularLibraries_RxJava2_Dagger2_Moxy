package com.hfad.popularlibrariesrxjava2dagger2moxy.framework.fragments

import android.annotation.SuppressLint
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hfad.popularlibrariesrxjava2dagger2moxy.R
import com.hfad.popularlibrariesrxjava2dagger2moxy.databinding.FragmentUsersBinding
import com.hfad.popularlibrariesrxjava2dagger2moxy.framework.AndroidScreens
import com.hfad.popularlibrariesrxjava2dagger2moxy.framework.App
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.adapter.UsersRVAdapter
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.data.user.GitHubUserRepositoryImpl
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.presenters.users.UsersPresenter
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.presenters.BackButtonListener
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.users.UsersView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment :
    MvpAppCompatFragment(R.layout.fragment_users),
    UsersView,
    BackButtonListener {

    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(GitHubUserRepositoryImpl(), App.instance.router, AndroidScreens())
    }
    private var adapter: UsersRVAdapter? = null

    private val vb by viewBinding(FragmentUsersBinding::bind)

    override fun init() = with(vb) {
        rvUsers.layoutManager = LinearLayoutManager(context)
        adapter = UsersRVAdapter(presenter.usersListPresenter)
        rvUsers.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()



    companion object {
        fun newInstance() = UsersFragment()
    }

}

