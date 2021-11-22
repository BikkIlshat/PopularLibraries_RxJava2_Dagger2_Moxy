package com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hfad.popularlibrariesrxjava2dagger2moxy.databinding.ItemUserBinding
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.presenters.users.IUserListPresenter
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.setUserAvatar
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.user.UserItemView


class UsersRVAdapter(private val presenter: IUserListPresenter) :

    RecyclerView.Adapter<UsersRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            itemView.setOnClickListener { presenter.itemClickListener?.invoke(this) }
        }

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        presenter.bindView(holder.apply { pos = position })
    }

    inner class ViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root), UserItemView {

        override fun setLogin(login: String, avatar_url: String) = with(binding) {
            tvLogin.text = login
            tvLogin.setUserAvatar(avatar_url)
        }

        override var pos = -1
    }
}
