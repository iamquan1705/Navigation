package com.iamquan.navigation

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.iamquan.navigation.databinding.ItemTagBinding
import java.util.*

class TagAdapter(private val list : List<String>, private val context : Context) :
    RecyclerView.Adapter<TagAdapter.ViewHodel>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagAdapter.ViewHodel {
        return TagAdapter.ViewHodel(
            ItemTagBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }
    override fun onBindViewHolder(holder: TagAdapter.ViewHodel, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {
            Toast.makeText(context,list[position],Toast.LENGTH_LONG).show()
        }

    }
    override fun getItemCount(): Int =list.size

    class ViewHodel(private val binding : ItemTagBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(text : String) {
            binding.tvTag.text = text
            val rnd = Random()
            val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
            binding.itemTag.setBackgroundColor(color)
        }

    }
}