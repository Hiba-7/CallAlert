package com.example.application2

import android.content.Context
import android.content.Intent
import com.example.application2.fragments.*
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.application2.databinding.ActivityMainBinding
import com.example.application2.fragments.DashboardFragment
import com.example.application2.fragments.AppelFragment
import com.example.application2.fragments.SignalerFragment


class MainActivity : AppCompatActivity() {
    private val appelFragment = AppelFragment()
    private val signalerFragment = SignalerFragment()
    //private val statistiqueFragment = StatistiqueFragment()
    private val dashboardFragment =DashboardFragment()
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val navHostFragment=supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController=navHostFragment.navController
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId)
            {

                R.id.dashboardFragment -> replaceFragment(DashboardFragment())
                R.id.appelFragment -> replaceFragment(AppelFragment())
                R.id.signalerFragment -> {
                    val intent = Intent(this,adapterActivity::class.java)
                    this.startActivity(intent)
                    finish()
                }
                R.id.statFragment -> replaceFragment(StatFragment())


            }
            true
        }

    }
    private fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainerView,fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }




}