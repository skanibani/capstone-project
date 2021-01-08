package com.example.sherlock.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sherlock.R
import com.example.sherlock.model.Item
import com.example.sherlock.databinding.ItemRegisteredItemBinding

class ItemAdapter(private val items: List<Item>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>(){
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemRegisteredItemBinding.bind(itemView)

        fun databind(item: Item) {
            binding.txtRegisteredItemCategory.text = item.category
            binding.txtRegisteredItemName.text = item.description
            binding.txtRegisteredItemLocation.text = item.location
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_registered_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}