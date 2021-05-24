package com.swetajain.viewbindingwithrecyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.swetajain.viewbindingwithrecyclerview.databinding.FragmentMainBinding
import com.swetajain.viewbindingwithrecyclerview.models.Word

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        binding.addButton.setOnClickListener {
            val word = binding.tietText.text.toString()
            val action =
                MainFragmentDirections.actionMainFragmentToWorListFragment(Word(name = word))
            Navigation.findNavController(view).navigate(action)
        }
        return view
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}