package com.hfad.popularlibrariesrxjava2dagger2moxy.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hfad.popularlibrariesrxjava2dagger2moxy.App.Navigation.router
import com.hfad.popularlibrariesrxjava2dagger2moxy.databinding.FragmentItemUserBinding
import com.hfad.popularlibrariesrxjava2dagger2moxy.model.retrofit.GithubUser
import com.hfad.popularlibrariesrxjava2dagger2moxy.model.RepositoryFactory
import com.hfad.popularlibrariesrxjava2dagger2moxy.model.network.NetworkStatusFactory
import com.hfad.popularlibrariesrxjava2dagger2moxy.presentation.UserPresenter
import com.hfad.popularlibrariesrxjava2dagger2moxy.utils.ImageLoader
import com.hfad.popularlibrariesrxjava2dagger2moxy.utils.schedulers.SchedulersFactory
import com.hfad.popularlibrariesrxjava2dagger2moxy.views.BackButtonListener
import com.hfad.popularlibrariesrxjava2dagger2moxy.views.UserView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(), UserView, BackButtonListener {
    companion object {
        private const val ARGS_USER = "ARG_USER"
        fun newInstance(githubUserLogin: String?) = UserFragment().apply {
            arguments = bundleOf(ARGS_USER to githubUserLogin)
        }
    }

    private val imageLoader = ImageLoader
    private val binding by viewBinding<FragmentItemUserBinding>(CreateMethod.INFLATE)
    private val user by lazy {
        arguments?.getString(ARGS_USER).orEmpty()
    }
    private val userPresenter by moxyPresenter {
        UserPresenter(
            user,
            RepositoryFactory.create(NetworkStatusFactory.create(context)),
            SchedulersFactory.create(),
            router
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun showUser(githubUser: GithubUser) {
        binding.userItemLogin.text = githubUser.login
    }

    override fun showAvatar(githubUser: GithubUser) {
        githubUser.avatarUrl?.let { imageLoader.load(it, binding.avatarImage) }
    }

    override fun init() {
        binding.reposList.layoutManager = LinearLayoutManager(context)
        binding.reposList.adapter = RepoListAdapter(userPresenter.reposPresenter)
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_SHORT).show()
    }


    @SuppressLint("NotifyDataSetChanged")
    override fun updateRepose() {
        binding.reposList.adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = userPresenter.backClick()

}