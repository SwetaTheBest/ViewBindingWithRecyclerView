package com.swetajain.viewbindingwithrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.swetajain.viewbindingwithrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view= binding.root

        setContentView(view)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}