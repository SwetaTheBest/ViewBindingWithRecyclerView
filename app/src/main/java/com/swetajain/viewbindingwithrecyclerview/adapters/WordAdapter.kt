package com.swetajain.viewbindingwithrecyclerview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.swetajain.viewbindingwithrecyclerview.databinding.ItemLayoutBinding
import com.swetajain.viewbindingwithrecyclerview.models.Word
import com.swetajain.viewbindingwithrecyclerview.utils.WordDiffUtils

class WordAdapter(var wordClickListener: WordClickListener) :
    RecyclerView.Adapter<WordAdapter.WordViewHolder>() {
    private var wordList = emptyList<Word>()

    inner class WordViewHolder(binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        val _binding = binding

        init {
            _binding.root.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                wordClickListener.onWordClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder._binding.tvText.text = wordList[position].name
    }

    override fun getItemCount(): Int {
        return wordList.size
    }

    fun setData(newWordList: List<Word>) {
        val diffUtil = WordDiffUtils(oldWords = wordList, newWords = newWordList)
        val diffResultList = DiffUtil.calculateDiff(diffUtil)
        wordList = newWordList
        diffResultList.dispatchUpdatesTo(this)
    }

    interface WordClickListener {
        fun onWordClick(position: Int)
    }
}