package com.diegoamribeiro.eventosapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.diegoamribeiro.eventosapp.R
import com.diegoamribeiro.eventosapp.domain.repository.Repository
import com.diegoamribeiro.eventosapp.presentation.viewmodel.HomeViewModel
import com.dmribeiro.pokedex_app.presentation.state.ResponseViewState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        requestApiData()
    }

    fun requestApiData() {
        lifecycleScope.launch {
            viewModel.getAllEvents()
            viewModel.eventsResponse.observe(this@MainActivity) { response ->
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