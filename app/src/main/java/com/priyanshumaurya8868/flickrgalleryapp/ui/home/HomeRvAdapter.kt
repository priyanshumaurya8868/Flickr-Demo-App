package com.priyanshumaurya8868.flickrgalleryapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.priyanshumaurya8868.flickrgalleryapp.api.models.Photo
import com.priyanshumaurya8868.flickrgalleryapp.databinding.HomeRvItemBinding
import com.priyanshumaurya8868.flickrgalleryapp.load

class HomeRvAdapter : ListAdapter<Photo, HomeRvAdapter.HomeVH>(object:
    DiffUtil.ItemCallback<Photo>() {
    override fun areItemsTheSame(oldItem: Photo, newItem: Photo) = oldItem == newItem

    override fun areContentsTheSame(oldItem: Photo, newItem: Photo) =  oldItem.toString() == newItem.toString()

}){

    inner class  HomeVH(val binding : HomeRvItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeVH {
        val inflater  = parent.context.getSystemService(LayoutInflater::class.java)
         val binding = HomeRvItemBinding.inflate(inflater,parent,false)
        return  HomeVH(binding)
    }

    override fun onBindViewHolder(holder: HomeVH, position: Int) {
        val item = getItem(position)
        holder.binding.imageView.load(item.urlS)
    }

}