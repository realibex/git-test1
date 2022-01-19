package com.example.recyclerview_ex

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RvAdapter(val items : MutableList<String>) : RecyclerView.Adapter<RvAdapter.viewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvAdapter.viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)

        return viewHolder(view)
    }

    interface ItemClick{
        fun onClick(view : View, position: Int)
    }

    var itemClick : ItemClick? = null

    override fun onBindViewHolder(holder: RvAdapter.viewHolder, position: Int) {
        holder.bindItems(items[position])

        if(itemClick != null){
            holder.itemView.setOnClickListener{ v->
                itemClick?.onClick(v, position)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bindItems(item : String){
            val rv_text = itemView.findViewById<TextView>(R.id.rvItem)
            rv_text.text = item

        }
    }
}