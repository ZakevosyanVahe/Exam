package com.vmd.examen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.vmd.examen.util.LoginFragmentDiffUtil
import com.vmd.examen.databinding.ItemRecyclerViewBinding
import com.vmd.examen.model.Image

class TitlesAdapter: ListAdapter<Image, TitlesAdapter.TitlesViewHolder>(
    AsyncDifferConfig.Builder(LoginFragmentDiffUtil()).build()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitlesViewHolder {
       return TitlesViewHolder(
            ItemRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: TitlesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class TitlesViewHolder(private val binding: ItemRecyclerViewBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(image: Image){
            binding.userId.text = image.id
            binding.title.text = image.title
            binding.photo.load(image.imageUrl)
        }

    }
}