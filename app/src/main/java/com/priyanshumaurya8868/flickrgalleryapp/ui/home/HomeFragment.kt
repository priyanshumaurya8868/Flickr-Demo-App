package com.priyanshumaurya8868.flickrgalleryapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.priyanshumaurya8868.flickrgalleryapp.databinding.FragmentHomeBinding
import com.priyanshumaurya8868.flickrgalleryapp.databinding.HomeRvItemBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var madapter : HomeRvAdapter
    private val viewModel : HomeViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        madapter = HomeRvAdapter()
        viewModel.photo.observe({lifecycle}){
            madapter.submitList(it)
        }

        setupRv()
        return binding.root
    }


    private fun setupRv() {
       _binding?.recyclerView?.apply {
           layoutManager =  GridLayoutManager(requireContext(),3)
           adapter = madapter
       }    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}