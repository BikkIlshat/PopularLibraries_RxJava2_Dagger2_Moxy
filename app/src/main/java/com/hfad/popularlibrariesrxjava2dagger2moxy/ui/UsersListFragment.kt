package com.hfad.popularlibrariesrxjava2dagger2moxy.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hfad.popularlibrariesrxjava2dagger2moxy.databinding.FragmentUsersListBinding
import com.hfad.popularlibrariesrxjava2dagger2moxy.model.GithubUsersRepo
import com.hfad.popularlibrariesrxjava2dagger2moxy.presentation.UsersPresenter
import com.hfad.popularlibrariesrxjava2dagger2moxy.ui.abs.AbsFragment
import com.hfad.popularlibrariesrxjava2dagger2moxy.views.UsersView
import moxy.ktx.moxyPresenter
import javax.inject.Inject


class UsersListFragment : AbsFragment(), UsersView {
    private val binding: FragmentUsersListBinding by viewBinding(CreateMethod.INFLATE)
    private var adapter: UserListAdapter? = null

    @Inject
    lateinit var repo: GithubUsersRepo

    private val userPresenter by moxyPresenter {
        UsersPresenter(
            repo = repo,
            router = router,
            schedulers = schedulers
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun init() = with(binding) {
        this.recycleViewUserList.layoutManager = LinearLayoutManager(context)
        adapter = UserListAdapter(userPresenter.userListPresenter, imageLoader)
        this.recycleViewUserList.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateUsersList() {
        adapter?.notifyDataSetChanged()
    }

    override fun showError(e: Throwable) {
        Toast.makeText(requireContext(), e.message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun newInstance() = UsersListFragment()
    }
}