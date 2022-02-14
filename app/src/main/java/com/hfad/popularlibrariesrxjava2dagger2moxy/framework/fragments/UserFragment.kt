package com.hfad.popularlibrariesrxjava2dagger2moxy.framework.fragments

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hfad.popularlibrariesrxjava2dagger2moxy.R
import com.hfad.popularlibrariesrxjava2dagger2moxy.databinding.FragmentUserBinding
import com.hfad.popularlibrariesrxjava2dagger2moxy.framework.App
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.data.user.GitHubUser
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.presenters.BackButtonListener
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.presenters.user.UserPresenter
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.user.UserView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment :
    MvpAppCompatFragment(R.layout.fragment_user),
    UserView,
    BackButtonListener {

    private val vb by viewBinding(FragmentUserBinding::bind)

    private val presenter: UserPresenter by moxyPresenter {
        val user = arguments?.getParcelable<GitHubUser>(USER) as GitHubUser
        UserPresenter(App.instance.router, user)
    }

    override fun setLogin(text: String) {
        text.also { vb.userLoginText.text = it }
    }

    override fun backPressed() = presenter.backPressed()

    companion object {
        private const val USER = "USER"
        fun newInstance(user: GitHubUser) : Fragment =
            UserFragment().apply {
                arguments = bundleOf().apply {
                    putParcelable(USER, user)
                }
            }
    }
}