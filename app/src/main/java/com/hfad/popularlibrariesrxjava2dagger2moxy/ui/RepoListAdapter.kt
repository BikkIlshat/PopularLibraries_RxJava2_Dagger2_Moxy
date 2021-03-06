package com.hfad.popularlibrariesrxjava2dagger2moxy.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hfad.popularlibrariesrxjava2dagger2moxy.databinding.ItemRepoLayotBinding
import com.hfad.popularlibrariesrxjava2dagger2moxy.presentation.UserPresenter
import com.hfad.popularlibrariesrxjava2dagger2moxy.views.RepoItemView

class RepoListAdapter(private val presenter: UserPresenter.ReposPresenter) :
    RecyclerView.Adapter<RepoListAdapter.ItemRepoHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemRepoHolder =
        ItemRepoHolder(
            ItemRepoLayotBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )
            .apply {
                itemView.setOnClickListener { presenter.itemClickedListener?.invoke(this) }
            }

    override fun onBindViewHolder(holder: ItemRepoHolder, position: Int) {
        presenter.bindView(holder.apply { pos = position })
    }

    override fun getItemCount(): Int = presenter.getCount()

    inner class ItemRepoHolder(private val binding: ItemRepoLayotBinding) :
        RecyclerView.ViewHolder(binding.root), RepoItemView {
        @SuppressLint("SetTextI18n")
        override fun setRepoName(name: String?) {
            binding.name.text = "Repo name: $name"
        }

        @SuppressLint("SetTextI18n")
        override fun setLanguage(language: String?) {
            binding.language.text = "language: $language"
        }

        @SuppressLint("SetTextI18n")
        override fun setDate(date: String?) {
            binding.creationDate.text = "created at: $date"
        }

        override var pos: Int = -1

    }
}