package com.swetajain.viewbindingwithrecyclerview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.swetajain.viewbindingwithrecyclerview.databinding.ItemLayoutBinding
import com.swetajain.viewbindingwithrecyclerview.models.Word
import com.swetajain.viewbindingwithrecyclerview.utils.WordDiffUtils

class WordAdapter : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {
    private var wordList = emptyList<Word>()
    class WordViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

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
        holder.binding.tvText.text = wordList[position].name
    }

    override fun getItemCount(): Int {
        return wordList.size
    }
    fun setData(newWordList: List<Word>){
      val diffUtil = WordDiffUtils(oldWords = wordList,newWords = newWordList)
        val diffResultList = DiffUtil.calculateDiff(diffUtil)
        wordList = newWordList
        diffResultList.dispatchUpdatesTo(this)
    }
}