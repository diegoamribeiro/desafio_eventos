package com.diegoamribeiro.eventosapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.diegoamribeiro.eventosapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeContainerView = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        navController = homeContainerView.navController
        setupActionBarWithNavController(navController)
    }



}