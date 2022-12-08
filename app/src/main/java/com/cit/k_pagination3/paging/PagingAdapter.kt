package com.cit.k_pagination3.paging

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.cit.k_pagination3.data.model.Result
import com.cit.k_pagination3.databinding.ItemQuoteBinding

class PagingAdapter :
    PagingDataAdapter<Result, PagingAdapter.QuoteViewHolder>(Comparator) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {

        val binding = ItemQuoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return QuoteViewHolder(binding)


    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        getItem(position)?.let {
            holder.binding.quoteTv.text = "${it.content} \nby : ${it.author}"

        }

    }


    class QuoteViewHolder(val binding: ItemQuoteBinding) : RecyclerView.ViewHolder(binding.root)
    companion object {
        private val Comparator =
            object : DiffUtil.ItemCallback<Result>() {
                override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                    return oldItem._id == newItem._id
                }

                override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                    return oldItem == newItem
                }


            }

    }


}