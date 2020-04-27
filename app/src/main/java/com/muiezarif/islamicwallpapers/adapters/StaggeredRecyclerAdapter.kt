package com.muiezarif.islamicwallpapers.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.muiezarif.islamicwallpapers.R
import com.muiezarif.islamicwallpapers.databinding.CustomRecyclerItemBinding
import de.hdodenhof.circleimageview.CircleImageView
import java.util.*


class StaggeredRecyclerAdapter(var context:Context?,var images:Array<Int>, listener:WallpaperViewClickListener): RecyclerView.Adapter<StaggeredRecyclerAdapter.MyViewHolder>() {
    var wallpaperClickListener:WallpaperViewClickListener=listener
    interface WallpaperViewClickListener {
        fun onClick(view: View?, position: Int,data:Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            var binding: CustomRecyclerItemBinding =DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.custom_recycler_item,parent,false)
            return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        loadImage(images[position],holder.binding.ivImage)
//        loadUserImage(images[position].user.profile_image.medium,holder.binding.civUser)
//        holder.binding.tvUsername.text=images[position].user.username

    }

    inner class MyViewHolder(var binding: CustomRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {
        init {
            binding.ivImage.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            wallpaperClickListener.onClick(binding.root,adapterPosition,images[adapterPosition])
        }
    }

    private fun loadImage(imagePath: Int,ivImage: ImageView) {
            context?.applicationContext?.let {
                Glide.with(it).load(imagePath)
                    .into(ivImage)
            }

    }

    private fun loadDogImage(imagePath: String?,ivImage: ImageView) {
        if (imagePath != null && !imagePath.trim { it <= ' ' }.isEmpty()) {
            context?.applicationContext?.let {
                Glide.with(it).load(imagePath)
                    .into(ivImage)
            }
        }
    }
    private fun loadUserImage(imagePath: String?,ivImage: CircleImageView) {
        if (imagePath != null && !imagePath.trim { it <= ' ' }.isEmpty()) {
            context?.applicationContext?.let {
                Glide.with(it).load(imagePath)
                    .into(ivImage)
            }
        }
    }
}