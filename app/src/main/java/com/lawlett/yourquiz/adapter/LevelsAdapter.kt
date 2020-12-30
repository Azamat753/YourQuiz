package com.lawlett.yourquiz.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lawlett.yourquiz.databinding.LevelItemBinding
import com.lawlett.yourquiz.room.data.GameLevel


class LevelsAdapter (private val listener: Listener):
    RecyclerView.Adapter<LevelsAdapter.LevelsViewHolder>() {
    private var list = listOf<GameLevel>()

    class LevelsViewHolder(private val itemBinding: LevelItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(levels: GameLevel, listener: Listener) {
            itemBinding.lvlBtn.text = levels.id.toString()
            itemBinding.lvlBtn.setOnClickListener { listener.onItemClick(levels.id) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LevelsViewHolder {
        val itemBinding =
            LevelItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LevelsViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: LevelsViewHolder, position: Int) {
        val gameLevel: GameLevel = list[position]
        holder.bind(gameLevel,listener)
    }

    fun add(model: MutableList<GameLevel>) {
        this.list = model
        notifyDataSetChanged()
    }

    interface Listener {
        fun onItemClick(level: Int?)
    }

}