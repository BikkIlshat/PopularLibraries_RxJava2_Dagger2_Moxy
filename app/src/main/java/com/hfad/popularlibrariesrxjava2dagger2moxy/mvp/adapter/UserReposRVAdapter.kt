package com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hfad.popularlibrariesrxjava2dagger2moxy.databinding.ItemUserRepoBinding
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.presenters.user.IUserReposListPresenter
import com.hfad.popularlibrariesrxjava2dagger2moxy.mvp.views.user.UserRepoItemView

class UserReposRVAdapter(private val presenter: IUserReposListPresenter) :
    RecyclerView.Adapter<UserReposRVAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemUserRepoBinding) :
        RecyclerView.ViewHolder(binding.root), UserRepoItemView {

        override fun setRepoName(repoName: String) {
            binding.tvRepoName.text = repoName
        }

        override var pos = -1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemUserRepoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            itemView.setOnClickListener {
                presenter.itemClickListener?.invoke(this)
            }
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        presenter.bindView(holder.apply { pos = position })

    override fun getItemCount() = presenter.getCount()
}