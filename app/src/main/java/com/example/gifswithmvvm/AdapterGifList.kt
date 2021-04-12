package com.example.gifswithmvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gifswithmvvm.databinding.GifItemBinding
import com.example.gifswithmvvm.domain.model.Original

class AdapterGifList(private val gifts: List<Original>, private val click: (Original) -> Unit) :
    RecyclerView.Adapter<AdapterGifList.ViewHolder>() {

    class ViewHolder(var binding: GifItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val infl = LayoutInflater.from(parent.context)
        val binding = GifItemBinding.inflate(infl, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = gifts[position]
        Glide.with(holder.binding.someGif.context).load(item.url).into(holder.binding.someGif)
        holder.binding.itemHolder.setOnClickListener {
            click(item)
        }
    }

    override fun getItemCount(): Int = gifts.size
}