package com.vmd.examen.util

import androidx.recyclerview.widget.DiffUtil
import com.vmd.examen.model.Image

class LoginFragmentDiffUtil: DiffUtil.ItemCallback<Image>() {
    override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean =
        oldItem == newItem
}