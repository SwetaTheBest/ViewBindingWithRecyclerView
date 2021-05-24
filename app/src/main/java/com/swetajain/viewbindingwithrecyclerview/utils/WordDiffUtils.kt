package com.swetajain.viewbindingwithrecyclerview.utils

import androidx.recyclerview.widget.DiffUtil
import com.swetajain.viewbindingwithrecyclerview.models.Word

class WordDiffUtils(
    private val oldWords: List<Word>,
    private val newWords: List<Word>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldWords.size
    }

    override fun getNewListSize(): Int {
        return newWords.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldWords[oldItemPosition].name == newWords[newItemPosition].name
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldWords[oldItemPosition].name != newWords[newItemPosition].name -> {
                false
            }
             oldWords[oldItemPosition].img != newWords[newItemPosition].img -> {
                false
            }

            else -> true
        }
    }
}