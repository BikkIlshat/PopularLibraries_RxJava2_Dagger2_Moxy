package com.hfad.popularlibrariesrxjava2dagger2moxy.framework.fragments

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hfad.popularlibrariesrxjava2dagger2moxy.R
import com.hfad.popularlibrariesrxjava2dagger2moxy.data.user.GitHubUserRepositoryFactory
import com.hfad.popularlibrariesrxjava2dagger2moxy.databinding.FragmentUsersBinding
import com.hfad.popularlibrariesrxjava2dagger2moxy.framework.App.Navigation.router
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.adapter.UsersRVAdapter
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.presenters.BackButtonListener
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.presenters.users.UsersPresenter
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.users.UsersView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment :
    MvpAppCompatFragment(R.layout.fragment_users),
    UsersView,
    BackButtonListener {

    private val viewBinding: FragmentUsersBinding by viewBinding()

    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            GitHubUserRepositoryFactory.create(),
            router
        )
    }

    private var adapter: UsersRVAdapter? = null

    override fun init() = with(viewBinding) {
        rvUsers.layoutManager = LinearLayoutManager(context)
        adapter = UsersRVAdapter(presenter.usersListPresenter)
        rvUsers.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()

    override fun showToast(message: String) {
        Toast.makeText(requireActivity(), message, Toast.LENGTH_LONG).show()
    }

    companion object {
        fun newInstance(): Fragment = UsersFragment()
    }

}

