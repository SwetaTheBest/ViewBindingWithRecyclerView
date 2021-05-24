package com.swetajain.viewbindingwithrecyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.swetajain.viewbindingwithrecyclerview.adapters.WordAdapter
import com.swetajain.viewbindingwithrecyclerview.databinding.FragmentWorListBinding
import com.swetajain.viewbindingwithrecyclerview.models.Word


/**
 * A simple [Fragment] subclass.
 */
class WorListFragment : Fragment() {

    private var _binding: FragmentWorListBinding? = null
    private val binding: FragmentWorListBinding get() = _binding!!
    private val wordAdapter by lazy { WordAdapter() }
    val args: WorListFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentWorListBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        binding.rvWord.adapter = wordAdapter
        val word1 = Word(name = "Sweta")
        val word2 = Word(name = "Sam")
        val word3 = Word(name = "Shubham")
        val word4 = Word(name = "Sita")
        val word5 = Word(name = "Sunita")
        val word6 = Word(name = "Sweet")
        val word7 = Word(name = "Seema")
        val word8 = Word(name = "Shona")
        val wordList = mutableListOf(word1, word3, word6, word8)
        wordList.add(args.word)
        wordAdapter.setData(wordList)

        view.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_worListFragment_to_mainFragment)
        }
        return view
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}