package com.diegoamribeiro.eventosapp.presentation.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.diegoamribeiro.eventosapp.R
import com.diegoamribeiro.eventosapp.databinding.FragmentListBinding
import com.diegoamribeiro.eventosapp.presentation.viewmodel.HomeViewModel
import com.dmribeiro.pokedex_app.presentation.state.ResponseViewState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        binding = FragmentListBinding.inflate(layoutInflater)

        requestApiData()

        return binding.root
    }

    private fun requestApiData() {
        lifecycleScope.launch {
            viewModel.getAllEvents()
            viewModel.eventsResponse.observe(viewLifecycleOwner) { response ->
                when (response) {
                    is ResponseViewState.Success -> {
                        response.data.let {
                            Log.d("***EventsActivity", it.toString())
                        }
                    }
                    is  ResponseViewState.Error -> {
                        Log.d("***EventsActivity", "Error!")
                    }
                    is ResponseViewState.Loading -> {
                        Log.d("***EventsActivity", "Loading...")
                    }
                    else -> {
                        Log.d("***EventsActivity", "Nothing")
                    }
                }
            }
        }
    }

}