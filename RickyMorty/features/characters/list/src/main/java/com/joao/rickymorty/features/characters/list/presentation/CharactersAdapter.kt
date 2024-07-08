package com.joao.rickymorty.features.characters.list.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.joao.rickymorty.features.characters.list.databinding.ItemRecyclerBinding
import com.joao.rickymorty.features.characters.list.domain.models.Result
import com.squareup.picasso.Picasso

class CharactersAdapter :  ListAdapter<Result, CharactersAdapter.ViewHolder>(Diff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemRecyclerBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.bind(it)
        }
    }



    inner class ViewHolder(
        private val binding: ItemRecyclerBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(result: Result) = binding.run {
            txtCard.text = result.name
            Picasso.get().load(result.image).into(imgcharacterCard)
        }
    }
    private companion object Diff : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean =
            oldItem.name == newItem.name
    }



}