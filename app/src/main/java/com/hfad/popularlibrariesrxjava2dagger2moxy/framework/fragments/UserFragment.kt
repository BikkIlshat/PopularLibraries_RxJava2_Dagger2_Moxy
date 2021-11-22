package com.hfad.popularlibrariesrxjava2dagger2moxy.framework.fragments

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hfad.popularlibrariesrxjava2dagger2moxy.R
import com.hfad.popularlibrariesrxjava2dagger2moxy.data.user.GitHubUserRepositoryFactory
import com.hfad.popularlibrariesrxjava2dagger2moxy.data.user.GitHubUserUserRepositories
import com.hfad.popularlibrariesrxjava2dagger2moxy.databinding.FragmentUserBinding
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.adapter.UserReposRVAdapter
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.presenters.user.UserPresenter
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.GithubUserViewModel
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.arguments
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.setUserAvatar
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.user.UserView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment :
    MvpAppCompatFragment(R.layout.fragment_user),
    UserView {

    companion object {

        private const val ARG_USER_LOGIN = "arg_user_login"

        fun newInstance(userId: String): Fragment =
            UserFragment().arguments(ARG_USER_LOGIN to userId)

    }

    private val viewBinding: FragmentUserBinding by viewBinding()
    private var reposAdapter: UserReposRVAdapter? = null

    private val userLogin: String by lazy {
        arguments?.getString(ARG_USER_LOGIN).orEmpty()
    }

    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(
            userLogin = userLogin,
            userRepository = GitHubUserRepositoryFactory.create()
        )
    }

    override fun showUser(user: GithubUserViewModel) = with(viewBinding) {
        tvLogin.text = user.login
        tvLogin.setUserAvatar(user.avatar_url)


    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateRepos() {
        reposAdapter?.notifyDataSetChanged()
    }

    override fun init() {
        val repos = viewBinding.userRepos
        reposAdapter = UserReposRVAdapter(presenter.reposPresenter)
        repos.apply {
            adapter = reposAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun showRepo(repo: GitHubUserUserRepositories) {
        AlertDialog.Builder(requireActivity())
            .setTitle("Repository info")
            .setMessage("Forks count: ${repo.forkCount}")
            .setPositiveButton("Ok") { dialog, _ -> dialog?.cancel() }
            .create()
            .show()
    }

    override fun showToast(message: String) {
        Toast.makeText(requireActivity(), message, Toast.LENGTH_LONG).show()
    }


}