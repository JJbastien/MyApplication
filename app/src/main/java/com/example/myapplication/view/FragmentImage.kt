package com.example.myapplication.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.DisplayImageLayoutBinding
import com.example.myapplication.di.Injector
import com.example.myapplication.model.state.UIState
import com.example.myapplication.view.adapter.ImageAdapter
import com.example.myapplication.viewmodel.ImageViewModel

private const val TAG = "FragmentImage"

class FragmentImage: Fragment() {

    private lateinit var binding: DisplayImageLayoutBinding
    private val viewModel: ImageViewModel by lazy{
        Injector.provideViewModelFactory().create(
            ImageViewModel::class.java
        )
    }

    private val adapter: ImageAdapter by lazy {
        ImageAdapter(emptyList())
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DisplayImageLayoutBinding.inflate(
            inflater,
            container,
            false
        )
        initObservables()
        initViews()
        return binding.root
    }

    private fun initViews() {
        binding.root.adapter = adapter
        binding.root.layoutManager = LinearLayoutManager(context)
    }

    private fun initObservables() {
        viewModel.data.observe(viewLifecycleOwner){
            updateUI(it)
        }
    }

    private fun updateUI(it: UIState) {
        when(it){
            is UIState.Response ->  {
        Log.d(TAG, "updateUIReponse: ${it.data}")
                adapter.updateNextPage(it.data.imageURLs)
            }
            is UIState.Error -> Toast.makeText(context, it.errorMessage, Toast.LENGTH_SHORT).show()
            is UIState.Loading -> Toast.makeText(context, "LOADING", Toast.LENGTH_SHORT).show()
        }
    }
}