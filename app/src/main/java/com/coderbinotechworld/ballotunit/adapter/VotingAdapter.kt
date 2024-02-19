package com.coderbinotechworld.ballotunit.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.coderbinotechworld.ballotunit.databinding.ItemForVotingBinding
import com.coderbinotechworld.ballotunit.model.ItemForVoting

class VotingAdapter(private val context: Context, private val itemList: ArrayList<ItemForVoting>): RecyclerView.Adapter<VotingAdapter.MViewHolder>() {

    private var onClickListener: OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewHolder {
        return MViewHolder(ItemForVotingBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: MViewHolder, position: Int) {
        val currentItem = itemList[position]

        holder.binding.tvName.text = currentItem.name
        holder.binding.tvSNo.text = currentItem.sNo.toString()
        holder.binding.tvSymbol.text = currentItem.symbol

        if (position == itemList.size -1) {
            holder.binding.vBottom.visibility = VISIBLE
        }

        holder.binding.vButton.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(position, currentItem.symbol)
            }
        }


    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(position: Int, symbol: String)
    }

    class MViewHolder(val binding: ItemForVotingBinding): RecyclerView.ViewHolder(binding.root)

}
