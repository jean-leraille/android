package com.example.episen.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.episen.data.models.Commune

import com.example.episen.databinding.ItemSearchResultBinding

class SearchResultAdapter(private val listener: ItemResultListener) :
    RecyclerView.Adapter<SearchResultAdapter.SearchResultViewHolder>() {
    interface ItemResultListener {
        fun onItemSelected(item: Commune)
    }

    var itemList: List<Commune> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultViewHolder {
        return SearchResultViewHolder(
            listener = listener,
            binding = ItemSearchResultBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SearchResultViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class SearchResultViewHolder(private val listener: ItemResultListener, private val binding: ItemSearchResultBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Commune) {
            binding.name.text = "${item.nom} (${item.code})"
            binding.name.setOnClickListener { listener.onItemSelected(item) }
        }
    }
}
