package com.example.gapiapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gapiapp.databinding.ItemBinding
import com.example.gapiapp.ui.SimplePost
import com.squareup.picasso.Picasso

class RecycleRviewAdapter(val simplePostList : List<SimplePost>):RecyclerView.Adapter<RecycleRviewAdapter.RAdapter>(){
    class RAdapter(val binding:ItemBinding):RecyclerView.ViewHolder(binding.root){
        fun render(simplePostList:SimplePost){
            Picasso.get().load(simplePostList.thumbnailUrl).into(binding.ivReddit)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RAdapter {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RAdapter(layoutInflater.inflate(R.layout.item, parent, false))
    }

    override fun onBindViewHolder(holder: RAdapter, position: Int) {
        holder.render(simplePostList[position])
    }

    override fun getItemCount(): Int {
        return simplePostList.size
    }
}